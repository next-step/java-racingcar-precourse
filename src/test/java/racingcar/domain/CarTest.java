package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("5자 넘는 이름으로 생성시 에러 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = {"six666", "seven77"})
    void nameLengthOver(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void create(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이동전략에 의해 이동이 된 후의 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 9 })
    void movableValue(int randomValue) {
        Car car = new Car("TEST");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동전략에 의해 이동이 되지 않은 후의 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void notMovableValue(int randomValue) {
        Car car = new Car("TEST");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }

    @DisplayName("우승자인지 확인 (우승자인 경우)")
    @Test
    void winner() {
        Car car = new Car("TEST");
        car.move(() -> true);
        assertThat(car.isWinner(Car.DEFAULT_POSITION + Car.MOVE_DISTANCE)).isTrue();
    }

    @DisplayName("우승자인지 확인 (우승자 아닌 경우)")
    @Test
    void notWinner() {
        Car car = new Car("TEST");
        assertThat(car.isWinner(Car.DEFAULT_POSITION + 1)).isFalse();
    }
}