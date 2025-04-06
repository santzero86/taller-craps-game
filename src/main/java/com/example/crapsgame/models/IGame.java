package com.example.crapsgame.models;

public interface IGame {
    /**
     * Evaluates the current roll and updates the game state accordingly.
     * @param shotValue the sum of two dice values.
     */
    void evaluateRoll(int shotValue);

    /**
     * Gets the number of games won.
     * @return the number of won games.
     */
    int getWonGames();

    /**
     * Gets the number of games lost.
     * @return the number of lost games.
     */
    int getLossGames();

    /**
     * Gets the current point value.
     * @return the point value.
     */
    int getPoint();

    /**
     * Gets the current round number.
     * @return the round number.
     */
    int getRound();
}
