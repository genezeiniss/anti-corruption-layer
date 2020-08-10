package com.gene.demo.digital_camera.anti_corruption_layer;

import com.gene.demo.digital_camera.core.EventProducer;
import com.gene.demo.digital_camera.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageRecordEventProducer {

    private final ImageTranslator imageTranslator;
    private final EventProducer eventProducer;

    public void sendImageRecordCreatedEvent(Image image) {
        ImageRecordCreatedEvent event = imageTranslator.translateImageToRecordCreatedEvent(image);
        eventProducer.sendEvent(event);
    }
}