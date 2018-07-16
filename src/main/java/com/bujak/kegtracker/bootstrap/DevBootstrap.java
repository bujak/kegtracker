package com.bujak.kegtracker.bootstrap;

import com.bujak.kegtracker.kegs.KegFactory;
import com.bujak.kegtracker.kegs.Card;
import com.bujak.kegtracker.kegs.KegRepository;
import com.bujak.kegtracker.players.Player;
import com.bujak.kegtracker.players.PlayerFactory;
import com.bujak.kegtracker.players.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DevBootstrap.class);
    private final PlayerRepository playerRepository;

    private KegRepository kegRepository;
    private KegFactory kegFactory;
    private PlayerFactory playerFactory;

    public DevBootstrap(KegRepository kegRepository, KegFactory kegFactory, PlayerFactory playerFactory, PlayerRepository playerRepository) {
        this.kegRepository = kegRepository;
        this.kegFactory = kegFactory;
        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Player owner = playerRepository.save(playerFactory.getPlayer("admin"));
        for (int i = 0; i < 9; i++) {
            kegRepository.save(this.kegFactory.getKeg(owner, Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.BLUE));
        }
        kegRepository.save(this.kegFactory.getKeg(owner, Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.SILVER));
        kegRepository.save(this.kegFactory.getKeg(owner, Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.GOLD));
        kegRepository.findAll().forEach(keg -> logger.info(keg.toString()));

    }
}
