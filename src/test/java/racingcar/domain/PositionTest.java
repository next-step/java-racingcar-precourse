package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("위치를 생성하면 초기 값은 0이다.")
    @Test
    void initialPosition() {

        Position position = new Position();

        assertThat(position.toString()).isEqualTo("");
    }

    @DisplayName("1회 전진하면 전진한 거리는 '-' 이다.")
    @Test
    void goOneDistance() {

        Position position = new Position();
        position.goForwardOneStep();

        assertThat(position.toString()).isEqualTo("-");
    }

    @DisplayName("위치를 출력하면 distance * '-'이 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---"}, delimiter = ':')
    void printDistance(int movingDistance, String printDistance) {

        Position position = new Position();

        for (int i = 0; i < movingDistance; i++) {
            position.goForwardOneStep();
        }

        assertThat(position.toString()).isEqualTo(printDistance);
    }

    @DisplayName("2회 전진한 Position 은 1회 전진한 Position 보다 크다.")
    @Test
    void greaterPosition() {

        Position oneStep = new Position();
        Position twoStep = new Position();

        oneStep.goForwardOneStep();
        twoStep.goForwardOneStep();
        twoStep.goForwardOneStep();

        assertThat(twoStep).isGreaterThan(oneStep);
    }


    @DisplayName("1회 전진한 Position 은 2회 전진한 Position 보다 작다.")
    @Test
    void lessPosition() {

        Position oneStep = new Position();
        Position twoStep = new Position();

        oneStep.goForwardOneStep();
        twoStep.goForwardOneStep();
        twoStep.goForwardOneStep();

        assertThat(oneStep).isLessThan(twoStep);
    }

    @DisplayName("같은 거리를 움직인 Position 은 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void equalDistance(int movingDistance) {

        Position position1 = new Position();
        Position position2 = new Position();

        for (int i = 0; i < movingDistance; i++) {
            position1.goForwardOneStep();
            position2.goForwardOneStep();
        }

        assertThat(position1).isEqualTo(position2);
    }

}
