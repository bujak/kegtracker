package com.bujak.kegtracker.players;

import org.springframework.stereotype.Component;

@Component
public class PlayerFactory {

    public Player getPlayer(String login) {
        Player player = new Player();
        player.setLogin(login);
        return player;
    }
}
