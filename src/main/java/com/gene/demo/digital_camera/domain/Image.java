package com.gene.demo.digital_camera.domain;

import lombok.Data;

import java.time.Instant;

@Data
public class Image {

    private String id;
    private String kind;
    private Resolution resolution;
    private Instant createdOn;
    private Instant modifiedOn;
}
