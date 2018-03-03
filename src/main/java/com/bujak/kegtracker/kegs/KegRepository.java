package com.bujak.kegtracker.kegs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KegRepository extends PagingAndSortingRepository<Keg, Long> {
}
