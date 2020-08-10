package com.gene.demo.film_camera.anti_corruption_layer;

import com.gene.demo.film_camera.domain.Frame;
import com.gene.demo.film_camera.domain.Photography;
import com.gene.demo.film_camera.domain.Size;
import com.gene.demo.film_camera.repository.PhotographyRepository;
import io.vavr.API;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.vavr.API.Case;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhotographyAdapter {

    private final PhotographyMapper photographyMapper;
    private final PhotographyRepository photographyRepository;

    protected void reflectImageCreationToPhotography(ImageRecordCreatedEvent event) {
        Photography photography = photographyMapper.mapImageRecordToPhotography(event);
        photography.setOptimalSize(calculateOptimalSizeAccordingToMaxFrame(photography.getMaxAvailableFrame()));
        log.info("select the paper type");
        log.info("print the photography");
        log.info("photography is about to be added to photo-album");
        photographyRepository.create(photography);
    }

    private Size calculateOptimalSizeAccordingToMaxFrame(Frame maxAvailableFrame) {
        return API.Match(maxAvailableFrame).of(
                Case(API.$(Frame.A1), Size.R10),
                Case(API.$(Frame.A2), Size.R10),
                Case(API.$(Frame.A3), Size.R8S),
                Case(API.$(Frame.A4), Size.R8),
                Case(API.$(Frame.A5), Size.R6),
                Case(API.$(Frame.A6), Size.R5),
                Case(API.$(Frame.A7), Size.R4),
                Case(API.$(Frame.A8), Size.R3),
                Case(API.$(Frame.A9), Size.R2),
                Case(API.$(Frame.A10), Size.R1));
    }
}
