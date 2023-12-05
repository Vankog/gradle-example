package app.dmo.gradletest.model;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class TrainTimeTest {

    @Test
    void shouldCreateRecord() {
        var trainTime = new TrainTime("London", "Brighton", LocalTime.of(9, 35), LocalTime.of(10, 30));
        assertThat(trainTime.departureStation()).isEqualTo("London");
    }
}
