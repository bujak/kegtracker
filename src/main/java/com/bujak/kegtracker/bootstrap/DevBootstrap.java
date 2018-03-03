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

        Keg keg1 = this.kegFactory.getKeg(Card.WHITE, Card.BLUE, Card.WHITE, Card.WHITE, Card.SILVER);
        Keg keg2 = this.kegFactory.getKeg(Card.WHITE, Card.BLUE, Card.SILVER, Card.WHITE, Card.BLUE);
        Keg keg3 = this.kegFactory.getKeg(Card.WHITE, Card.WHITE, Card.WHITE, Card.WHITE, Card.GOLD);
        kegRepository.save(keg1);
        kegRepository.save(keg2);
        kegRepository.save(keg3);

        kegRepository.findAll().forEach(keg -> logger.info(keg.toString()));

    }
}
