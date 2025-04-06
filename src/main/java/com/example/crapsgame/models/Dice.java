package com.example.crapsgame.models;

/**
 * Represents a single six-sided dice used in the Craps game.
 * Provides functionality to roll the dice and get the corresponding image path.
 */
public class Dice implements IDice {
    /**
     * The current value of the dice after rolling (1-6).
     */
    int value;

    /**
     * Constant base path to the dice images
     */
    String IMAGES_PATH = "/com/example/crapsgame/imeges/dices/dice";

    /**
     * Rolls the dice and generates a random value between 1 and 6.
     * @return the generated dice value.
     */
    public int roll(){
        this.value = (int)(Math.random()*6+1);
        return this.value;
    }

    /**
     * Returns the image path corresponding to the current dice value.
     * @return a string representing the image path for the dice value.
     */
    public String getDiceImagePath() {
        return IMAGES_PATH + Integer.toString(this.value) + ".png";
    }
}
