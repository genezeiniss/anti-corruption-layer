package com.gene.demo.digital_camera.anti_corruption_layer;

import com.gene.demo.digital_camera.domain.Image;
import com.gene.demo.digital_camera.domain.Resolution;
import io.vavr.API;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static io.vavr.API.Case;

@Service
public class ImageTranslator {

    protected ImageRecordCreatedEvent translateImageToRecordCreatedEvent(Image image) {
        return ImageRecordCreatedEvent.builder()
                .imageRefId(image.getId())
                .maxAvailableFrame(translateImageResolutionToMaxFrame(image.getResolution()))
                .dateOnPhoto(translateImageCreationDateToDateOnPhoto(image.getCreatedOn()))
                .build();
    }

    private String translateImageResolutionToMaxFrame(Resolution resolution) {
        return API.Match(resolution).of(
                Case(API.$(Resolution.SIZE_4680_X_6620), () -> "A1"),
                Case(API.$(Resolution.SIZE_3300_X_4680), () -> "A2"),
                Case(API.$(Resolution.SIZE_2340_X_3300), () -> "A3"),
                Case(API.$(Resolution.SIZE_2490_X_3510), () -> "A4"),
                Case(API.$(Resolution.SIZE_1740_X_2490), () -> "A5"),
                Case(API.$(Resolution.SIZE_1230_X_1740), () -> "A6"),
                Case(API.$(Resolution.SIZE_870_X_1230), () -> "A7"),
                Case(API.$(Resolution.SIZE_600_X_870), () -> "A8"),
                Case(API.$(Resolution.SIZE_450_X_600), () -> "A9"),
                Case(API.$(Resolution.SIZE_300_X_450), () -> "A10"));
    }

    private String translateImageCreationDateToDateOnPhoto(Instant imageCreatedOn) {
        LocalDate imageCreationDate = imageCreatedOn.atZone(ZoneOffset.UTC).toLocalDate();
        int date = imageCreationDate.getDayOfMonth();
        int month = imageCreationDate.getMonthValue();
        int year = imageCreationDate.getYear();
        return String.format("%s  %s'%s", date, month, String.valueOf(year).substring(2));
    }
}
