package com.bujak.kegtracker.kegs;

import com.bujak.kegtracker.players.Player;
import com.bujak.kegtracker.players.PlayerNotFoundException;
import com.bujak.kegtracker.players.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KegFactory {

    private PlayerRepository playerRepository;

    @Autowired
    public KegFactory(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Keg getKeg(Player owner, Card r1, Card r2, Card r3, Card r4, Card r5) {
        return new Keg(owner, Arrays.asList(r1, r2, r3, r4, r5));
    }

    public Keg getKeg(Long ownerId, Card r1, Card r2, Card r3, Card r4, Card r5) {
        return playerRepository.findById(ownerId)
                .map(player -> new Keg(player, Arrays.asList(r1, r2, r3, r4, r5)))
                .orElseThrow(PlayerNotFoundException::new);
    }

}
