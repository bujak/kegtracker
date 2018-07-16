package com.bujak.kegtracker.kegs;

import com.bujak.kegtracker.players.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegRepository extends PagingAndSortingRepository<Keg, Long> {

    List<Keg> findAll();

    List<Keg> findAllByCardsContains(Card card);

    List<Keg> findByOwner(Player player);
}
