package com.bujak.kegtracker.players;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository  extends PagingAndSortingRepository<Player, Long> {
}
