package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @DisplayName("생성자에 넘긴 값으로 포지션값이 설정되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 10 })
    void create(int position) {
        CarPosition carPosition = new CarPosition(position);
        assertThat(carPosition.getPosition()).isEqualTo(position);
    }

    @DisplayName("위치 이동이 잘 적용되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 10 })
    void addPosition(int addPosition) {
        CarPosition carPosition = new CarPosition(0);
        carPosition.addPosition(addPosition);
        assertThat(carPosition.getPosition()).isEqualTo(addPosition);
    }
}