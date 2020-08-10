package com.gene.demo.film_camera.domain;

import lombok.Data;

@Data
public class Photography {

    private String imageRefId;
    private String dateOnPhoto;
    private Frame maxAvailableFrame;
    private Size optimalSize;
}
