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

/**
 * Controller class for managing the Craps game logic and user interface.
 * Handles player interactions, dice rolling, game state updates, and label/image updates.
 * @author David Valencia
 * @author Santiago Guerrero
 * @author Juan Pablo Escamilla
 */
public class GameController {

    /**
     * Displays the nickname of the current player.
     */
    @FXML
    private Label nicknameLabel;

    /**
     * Displays the sum of the two dice after each roll.
     */
    @FXML
    private Label rollScoreLabel;

    /**
     * Displays the number of rounds the player has lost.
     */
    @FXML
    private Label losePlays;

    /**
     * Displays the current "point" in the game.
     * If the point is set, the player must roll that number again to win.
     */
    @FXML
    private Label pointLabel;

    /**
     * Displays the number of rounds the player has won.
     */
    @FXML
    private Label winPlace;

    /**
     * Displays the game's current state or outcome message.
     */
    @FXML
    private Label stateLabel;

    /**
     * Displays the current round number.
     */
    @FXML
    private Label roundLabel;

    /**
     * ImageView for displaying the image of the first dice.
     */
    @FXML
    private ImageView diceImageView1;

    /**
     * ImageView for displaying the image of the second dice.
     */
    @FXML
    private ImageView diceImageView2;

    /**
     * The current player playing the game.
     */
    private Player player;

    /**
     * Manages the internal game logic and tracks the state (rounds, wins, losses, point, etc).
     */
    private Game gameState = new Game();

    /**
     * Stores the result of the last dice roll (sum of dice1 and dice2).
     */
    private int rollScore = 0;

    /**
     * Sets the player object for this game session.
     *
     * @param player The player to be associated with the game.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Shows the nickname of the current player in the UI.
     */
    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    /**
     * Triggered when the "Play" button is clicked.
     * Rolls two dice, updates their images, calculates the roll score,
     * and refreshes the labels with the new game state.
     *
     * @param event The action event triggered by the button.
     */
    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int diceValue1 = dice1.roll();
        int diceValue2 = dice2.roll();
        this.rollScore = diceValue1 + diceValue2;

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(dice1.getDiceImagePath())));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(dice2.getDiceImagePath())));

        this.updateLabels();
    }

    /**
     * Triggered when the "Help" button is clicked.
     * Opens a new window with game instructions loaded from the FXML view.
     *
     * @param event The action event triggered by the button.
     * @throws IOException If the instructions view cannot be loaded.
     */
    @FXML
    void onActionHelpButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/crapsgame/instruction-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Craps game");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Updates all UI labels based on the current game state and roll score.
     * Determines whether the player won, lost, or established a point.
     */
    void updateLabels() {
        this.rollScoreLabel.setText(String.valueOf(this.rollScore));

        int previousPoint = this.gameState.getPoint();
        int previousWins = this.gameState.getWonGames();
        int previousLosses = this.gameState.getLossGames();

        // Evaluate current roll and update game state (win/loss/point)
        this.gameState.evaluateRoll(this.rollScore);

        // Refresh labels with updated values
        this.winPlace.setText(String.valueOf(this.gameState.getWonGames()));
        this.pointLabel.setText(String.valueOf(this.gameState.getPoint()));
        this.losePlays.setText(String.valueOf(this.gameState.getLossGames()));
        this.roundLabel.setText(String.valueOf(this.gameState.getRound()));

        int newPoint = this.gameState.getPoint();
        int newWins = this.gameState.getWonGames();
        int newLosses = this.gameState.getLossGames();

        // Display appropriate message based on game result
        if (newWins > previousWins) {
            this.stateLabel.setText("¡Ganaste la ronda! \n ¿Seguimos roleando?");
            this.rollScore = 0;
            this.rollScoreLabel.setText(String.valueOf(this.rollScore));
        } else if (newLosses > previousLosses) {
            this.stateLabel.setText("¡Craps! Perdiste esta ronda \n ¿seguimos roleando?");
        } else if (previousPoint == 0 && newPoint != 0) {
            this.stateLabel.setText("¡Tienes un punto!");
        }
    }
}
