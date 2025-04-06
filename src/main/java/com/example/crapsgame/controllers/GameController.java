package com.example.crapsgame.controllers;

import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Game;
import com.example.crapsgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Label losePlays;

    @FXML
    private Label pointLabel;

    @FXML
    private Label winPlace;

    @FXML
    private ImageView diceImageView1;

    @FXML
    private Label stateLabel;


    @FXML
    private ImageView diceImageView2;

    @FXML
    private Label roundLabel;

    private Player player;

    private Game gameState = new Game();

    private int rollScore = 0;

    public void initialize() {
        this.stateLabel.setText("It's Craps time!");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int diceValue1 = dice1.roll();
        int diceValue2 = dice2.roll();
        this.rollScore = diceValue1+ diceValue2;

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));

        this.updateLabels();
    }

    @FXML
    void onActionHelpButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/crapsgame/instruction-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("My Game");
        stage.setScene(new Scene(root));
        stage.show();
    }


    void updateLabels() {
        this.rollScoreLabel.setText(String.valueOf(this.rollScore));

        int previousPoint = this.gameState.getPoint();
        int previousWins = this.gameState.getWonGames();
        int previousLosses = this.gameState.getLossGames();

        // cuando evaluamos la tirada, los valores de puntos, ganadas, perdidas se actualizan
        this.gameState.evaluateRoll(this.rollScore);

        this.winPlace.setText(String.valueOf(this.gameState.getWonGames()));
        this.pointLabel.setText(String.valueOf(this.gameState.getPoint()));
        this.losePlays.setText(String.valueOf(this.gameState.getLossGames()));
        this.roundLabel.setText(String.valueOf(this.gameState.getRound()));

        int newPoint = this.gameState.getPoint();
        int newWins = this.gameState.getWonGames();
        int newLosses = this.gameState.getLossGames();

        // basta con revisar si esos contadores han aumentado o no
        if (newWins > previousWins) {
            this.stateLabel.setText("¡Ganaste la ronda! ¿Seguimos roleando?");
            this.rollScore = 0;
            this.rollScoreLabel.setText(String.valueOf(this.rollScore));
        } else if (newLosses > previousLosses) {
            this.stateLabel.setText("¡Craps! Perdiste esta ronda, ¿seguimos roleando?");
        } else if (previousPoint == 0 && newPoint != 0) {
            this.stateLabel.setText("¡Tienes un punto!");
        }
    }
}