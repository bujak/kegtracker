package com.bujak.kegtracker.kegs;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kegs")
public class KegController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KegController.class);

    private KegService service;

    public KegController(KegService service) {
        this.service = service;
    }

    @GetMapping("/when/gold")
    public Integer whenGold(){
        return service.calculateWhenNext(Card.GOLD);
    }

    @GetMapping("/when/silver")
    public Integer whenSilver(){
        return service.calculateWhenNext(Card.SILVER);
    }
}
