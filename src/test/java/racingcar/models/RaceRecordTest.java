package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceRecordTest {

    private RaceRecord record;

    @BeforeEach
    void setUp() {
        this.record = new RaceRecord(
            1,
            new RacingCar(new Car("pobi")),
            RaceResult.GO
        );
    }

    @Test
    @DisplayName("자동차 이름으로 레이싱카 일치 여부를 확인한다.")
    void is_equal_car_name() {
        assertThat(this.record.isEqualCarByName("pobi")).isTrue();
        assertThat(this.record.isEqualCarByName("crong")).isFalse();
    }

    @Test
    @DisplayName("레이스 결과 일치 여부를 확인한다.")
    void is_equal_result() {
        assertThat(this.record.isEqualResult(RaceResult.GO)).isTrue();
        assertThat(this.record.isEqualResult(RaceResult.STOP)).isFalse();
    }

}