package com.gene.demo.film_camera.anti_corruption_layer;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReflectImageOnPhotographyActor {

    private final PhotographyAdapter photographyAdapter;

    @EventListener
    public void onImageRecordCreatedEvent(ImageRecordCreatedEvent event) {
        photographyAdapter.reflectImageCreationToPhotography(event);
    }
}
