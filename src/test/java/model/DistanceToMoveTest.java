package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceToMoveTest {

    @DisplayName("이동할 거리는 0 ~ 9 범위의 값이 아니면 Exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void distanceToMoveMustBe0to9(int distance) {
        assertThatThrownBy(() -> new DistanceToMove(distance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차가 이동할 거리는 0 ~ 9 범위만 가능합니다.");
    }
}
