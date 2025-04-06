package com.example.crapsgame.models;


/***
 * This represents the state of the CrapsGame.
 * @author David Valencia
 * @author Santiago Guerrero
 * @author Juan Pablo Escamilla
 */
public class Game implements IGame {
    private int point;
    private int wonGames;
    private int lossGames;
    private int round;


    public Game() {
        this.point = 0;
        this.wonGames = 0;
        this.lossGames = 0;
        this.round = 1;
    }


    /**
     * Evaluates each round of the Craps Game.
     * Each iteration change the attributes of this class, representing the state of the game.
     * @param shotValue - sum of roll values of dice1 and dice2
     */
    public void evaluateRoll(int shotValue) {
        if (this.point == 0) {
            if (shotValue == 7 || shotValue == 11) {
                this.wonGames++;
                this.round++;
            }
            else if (shotValue == 2 || shotValue == 3 || shotValue == 12) {
                this.lossGames++;
                this.round++;
            }
            else {
                this.point = shotValue;
            }
        } else {
            if (shotValue == this.point) {
                this.wonGames++;
                this.round++;
                this.point = 0;
            }
            else if (shotValue == 7) {
                this.lossGames++;
                this.round++;
                this.point = 0;
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

    /**
     * Retrieves the current round of the game.
     * @return the value of the round.
     */
    public int getRound() {
        return round;
    }
}