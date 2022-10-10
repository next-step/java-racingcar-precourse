package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriveTest {

    @Test
    void 정지_진행_판단() {
        assertThat(new Drive(() -> 0).move()).isEqualTo(Drive.STOP_POINT);
        assertThat(new Drive(() -> Drive.MOVE_DECIDE_STANDARD_NUMBER - 1).move()).isEqualTo(Drive.STOP_POINT);
        assertThat(new Drive(() -> Drive.MOVE_DECIDE_STANDARD_NUMBER).move()).isEqualTo(Drive.MOVE_POINT);
        assertThat(new Drive(() -> 9).move()).isEqualTo(Drive.MOVE_POINT);
    }
}