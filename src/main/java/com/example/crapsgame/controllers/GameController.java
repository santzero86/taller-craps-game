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
    private ImageView diceImageView2;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    //private int rollCount = 0;

    private Game gameState;
    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Game game = new Game();
        int diceValue1 = dice1.roll();
        int diceValue2 = dice2.roll();
        int rollScore = diceValue1+ diceValue2;


        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));
        this.rollScoreLabel.setText(String.valueOf(rollScore));
        game.evaluateRoll(diceValue1, diceValue2);
        this.winPlace.setText(String.valueOf(game.getWonGames()));
        this.pointLabel.setText(String.valueOf(game.getPoint()));
        this.losePlays.setText((String.valueOf(game.getLossGames())));
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
}
