package com.example.crapsgame.models;

/***
 * This represents the state of the CrapsGame.
 * @author David Valencia
 * @author Santiago Guerrero
 * @author Juan Pablo Escamilla
 */
public class Game {
    private int point;
    private int wonGames;
    private int lossGames;

    public Game() {
        this.point = 0;
        this.wonGames = 0;
        this.lossGames = 0;
    }

    /**
     * Evaluates each round of the Craps Game.
     * Each iteration change the attributes of this class, representing the state of the game.
     * @param diceValue1 - roll value of first dice.
     * @param diceValue2 - roll value of second dice.
     */
    public void evaluateRoll(int diceValue1, int diceValue2) {
        int shotValue = diceValue1 + diceValue2;
        if (this.point == 0) {
            if (shotValue == 7 || shotValue == 11) {
                this.wonGames++;
            }
            else if (shotValue == 2 || shotValue == 3 || shotValue == 12) {
                this.lossGames++;
            }
            else {
                this.point = shotValue;
            }
        } else {
            if (shotValue == this.point) {
                this.wonGames++;
            }
            else if (shotValue == 7) {
                this.lossGames--;
            }
            else {
                this.point = shotValue;
            }
        }
    }

    /**
     * Retrieve the won games.
     * @return the won game.
     */
    public int getWonGames() {
        return this.wonGames;
    }

    /**
     * Retrieve the loss games.
     * @return the loss game.
     */
    public int getLossGames() {
        return this.lossGames;
    }

    /**
     * Retrieve the current point.
     * @return the value of the point.
     */
    public int getPoint() {
        return this.point;
    }
}
