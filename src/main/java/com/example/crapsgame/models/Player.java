package com.example.crapsgame.models;

/**
 * Represents a player in the Craps game.
 * Each player has a unique nickname used for identification.
 * @author David Valencia
 * @author Santiago Guerrero
 * @author Juan Pablo Escamilla
 */
public class Player implements IPlayer {
    /**
     * Nickname defined by the player
     */
    private String nickname;

    /**
     * Retrieves the player's nickname.
     * @return the nickname of the player.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the player's nickname.
     * @param nickname the new nickname for the player.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
