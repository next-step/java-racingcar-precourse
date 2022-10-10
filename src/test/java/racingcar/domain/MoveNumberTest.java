package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.time.temporal.ValueRange;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveNumberTest {
    @Test
    void 랜덤_MoveNumber_범위테스트() {
        int moveNumberRandomly = new MoveNumber().getMoveNumber();
        ValueRange boundary = ValueRange.of(0, 9);

        assertThat(boundary.isValidIntValue(moveNumberRandomly)).isTrue();
    }
}
