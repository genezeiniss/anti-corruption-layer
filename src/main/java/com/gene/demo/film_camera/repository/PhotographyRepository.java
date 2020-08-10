package com.gene.demo.film_camera.repository;

import com.gene.demo.film_camera.domain.Photography;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PhotographyRepository {

    public void create(Photography photography) {
        log.info("create photography that related to {} image", photography.getImageRefId());
    }
}
