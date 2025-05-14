package com.example.userservice.service;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelayPurposeServiceImpl implements DelayPurposeService {

    @Override
    public void delayPurpose() {
        log.info("Init delay process");

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            log.info("Error in delay process");
            log.error("Error base: ");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        log.info("End delay process");
        
    }

}
