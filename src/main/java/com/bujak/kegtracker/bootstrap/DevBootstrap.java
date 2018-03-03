package com.bujak.kegtracker.bootstrap;

import com.bujak.kegtracker.kegs.KegFactory;
import com.bujak.kegtracker.kegs.Keg;
import com.bujak.kegtracker.kegs.Card;
import com.bujak.kegtracker.kegs.KegRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DevBootstrap.class);

    private KegRepository kegRepository;
    private KegFactory kegFactory;

    public DevBootstrap(KegRepository kegRepository, KegFactory kegFactory) {
        this.kegRepository = kegRepository;
        this.kegFactory = kegFactory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        for (int i = 0; i < 9; i++) {
            kegRepository.save(this.kegFactory.getKeg(Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.BLUE));
        }
        kegRepository.save(this.kegFactory.getKeg(Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.SILVER));
        kegRepository.save(this.kegFactory.getKeg(Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.GOLD));
        kegRepository.findAll().forEach(keg -> logger.info(keg.toString()));

    }
}
