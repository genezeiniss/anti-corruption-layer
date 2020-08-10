package com.gene.demo.digital_camera.anti_corruption_layer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ImageRecordCreatedEvent {

    String imageRefId;
    String dateOnPhoto;
    String maxAvailableFrame;
}
