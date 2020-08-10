package com.gene.demo.film_camera.anti_corruption_layer;

import com.gene.demo.film_camera.domain.Photography;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotographyMapper {

    private final ModelMapper modelMapper;

    protected Photography mapImageRecordToPhotography(ImageRecordCreatedEvent event) {
        return modelMapper.map(event, Photography.class);
    }
}
