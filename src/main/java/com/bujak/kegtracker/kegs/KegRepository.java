package com.bujak.kegtracker.kegs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KegRepository extends PagingAndSortingRepository<Keg, Long> {

    List<Keg> findAll();

    List<Keg> findAllByCardsContains(Card card);
}
