package com.example.crapsgame.models;

public interface IPlayer {
    /**
     * Gets the nickname of the player.
     * @return the player's nickname.
     */
    String getNickname();

    /**
     * Sets the nickname of the player.
     * @param nickname the nickname to set.
     */
    void setNickname(String nickname);
}
