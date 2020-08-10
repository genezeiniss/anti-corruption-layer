package com.gene.demo.digital_camera.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventProducer {

    public <T> void sendEvent(T event) {
        log.info("sending event {}", event.getClass());
    }
}