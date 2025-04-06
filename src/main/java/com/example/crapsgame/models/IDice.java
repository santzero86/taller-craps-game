package com.example.crapsgame.models;

public interface IDice {
    /**
     * Rolls the dice and returns the result.
     * @return the value after rolling the dice (1-6).
     */
    int roll();

    /**
     * Gets the image path corresponding to the current value of the dice.
     * @return the image path string.
     */
    String getDiceImagePath();
}
