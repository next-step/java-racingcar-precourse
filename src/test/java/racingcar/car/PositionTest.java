package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Position에 대해 테스트 한다.")
class PositionTest {

    @DisplayName("Position의 초기 값은 0이다.")
    @Test
    void initValueIsZero() {
        final Position position = Position.of();
        assertThat(position.value()).isEqualTo(0);
    }

    @ParameterizedTest(name = "Position의 value는 반복문 횟수만큼 증가한다. loopCount={0}")
    @ValueSource(ints = {0, 1, 2, 10, 100})
    void increment(int loopCount) {
        final Position position = increasedPosition(loopCount);
        assertThat(position.value()).isEqualTo(loopCount);
    }

    @DisplayName("Position는 오름차순으로 정렬된다.")
    @Test
    void sortedByValue() {
        final List<Position> positions = Arrays.asList(increasedPosition(1), increasedPosition(100),
                                                       increasedPosition(10), increasedPosition(3),
                                                       increasedPosition(50), increasedPosition(0));

        Collections.sort(positions);

        assertThat(positions).extracting("value")
                             .containsExactly(100, 50, 10, 3, 1, 0);
    }

    private static Position increasedPosition(int loopCount) {
        final Position position = Position.of();
        for (int i = 0; i < loopCount; i++) {
            position.increment();
        }
        return position;
    }
}
