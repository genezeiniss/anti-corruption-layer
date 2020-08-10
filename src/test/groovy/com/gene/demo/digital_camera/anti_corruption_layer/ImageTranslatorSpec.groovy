package com.gene.demo.digital_camera.anti_corruption_layer

import com.gene.demo.digital_camera.domain.Image
import spock.lang.Specification

import java.time.Instant

import static com.gene.demo.digital_camera.domain.Resolution.SIZE_870_X_1230

class ImageTranslatorSpec extends Specification {

    ImageTranslator imageTranslator

    def setup() {
        imageTranslator = new ImageTranslator()
    }

    def "translate image to record created event"() {
        given: "image"
        def image = new Image(id: "image-uuid", resolution: SIZE_870_X_1230, createdOn: Instant.now())

        when: "translate image to record created event is called"
        def event = imageTranslator.translateImageToRecordCreatedEvent(image)

        then: "event expected to be returned with following values"
        assert event.imageRefId == "image-uuid"
        assert event.maxAvailableFrame == "A7"
        assert event.dateOnPhoto != null
    }
}