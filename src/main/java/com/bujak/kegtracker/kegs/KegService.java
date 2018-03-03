package com.bujak.kegtracker.kegs;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KegService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KegService.class);

    private KegRepository repository;

    public KegService(KegRepository repository) {
        this.repository = repository;
    }

    public Integer calculateWhenNext(Card card) {
        Integer counter = card == Card.GOLD ? 40 : 10;

        List<Keg> all = repository.findAll();
        Optional<Keg> lastKeg = all.stream().filter(k -> k.getCards().contains(card)).reduce((first, second) -> second);
        logger.info(lastKeg.toString());
        return lastKeg.map(keg -> counter + 1 - (all.size() - all.indexOf(keg))).orElseGet(() -> counter - all.size());
    }

}
