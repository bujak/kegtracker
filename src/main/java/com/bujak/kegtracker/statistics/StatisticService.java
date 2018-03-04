package com.bujak.kegtracker.statistics;

import com.bujak.kegtracker.kegs.Card;
import com.bujak.kegtracker.kegs.Keg;
import com.bujak.kegtracker.kegs.KegRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    KegRepository kegRepository;

    public StatisticService(KegRepository kegRepository) {
        this.kegRepository = kegRepository;
    }

    public Statistics generateStats() {
        return new Statistics(
                getCountByRarity(Card.GOLD),
                getCountByRarity(Card.SILVER),
                getCountByRarity(Card.BLUE),
                getCountByRarity(Card.WHITE),
                kegRepository.findAll().size()
        );
    }

    private Integer getCountByRarity(Card card) {
        List<Keg> whites = this.kegRepository.findAllByCardsContains(card);
        return whites.stream().mapToInt(keg -> keg.getCards().stream().filter(c -> c.equals(card)).collect(Collectors.toList()).size()).sum();
    }
}
