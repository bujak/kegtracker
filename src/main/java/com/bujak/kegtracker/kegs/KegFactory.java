package com.bujak.kegtracker.kegs;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KegFactory {

    public Keg getKeg(Card r1, Card r2, Card r3, Card r4, Card r5) {
        return new Keg(Arrays.asList(r1, r2, r3, r4, r5));
    }
}
