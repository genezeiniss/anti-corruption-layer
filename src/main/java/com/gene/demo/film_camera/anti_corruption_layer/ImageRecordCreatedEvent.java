package com.gene.demo.film_camera.anti_corruption_layer;

import lombok.Value;

@Value
public class ImageRecordCreatedEvent {

    String imageRefId;
    String dateOnPhoto;
    String maxAvailableFrame;
}
