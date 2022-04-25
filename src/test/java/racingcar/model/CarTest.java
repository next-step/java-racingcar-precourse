package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"Jane, 0, Jane:0", "Steve, 1, Steve:1"})
    @DisplayName("게임에 이용할 객체 Car에 대한 initialization 테스트")
    void carInstanceInitializationAndTest(String name, int initial, String expected) {
        Car car = new Car(name, initial);
        assertThat(car.showResult()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"Jeremy, 0", "Jennifer, 1"})
    @DisplayName("이름 길이가 5자 이상일 때, 똑같이 예외 발생하는 지 확인")
    void carInstanceInitializationFailedBecauseNameLengthIsOver5(String name, int initial) {
        assertThatThrownBy(
                () -> new Car(name, initial)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
        ;
    }

    @ParameterizedTest
    @CsvSource(value = {"Jane, 0, Jane:1", "Steve, 3, Steve:4"})
    @DisplayName("move method 파라미터에 4 이상의 값이 들어갈 경우, 전진거리 증가")
    void carInitAndMoveForwardWithNumberOver4(String name, int initial, String expected) {
        Car car = new Car(name, initial);
        car.move(() -> true);
        assertThat(car.showResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jane, 0, Jane:0", "Steve, 3, Steve:3"})
    @DisplayName("move method 파라미터에 3 이하의 값이 들어갈 경우, 전진거리 증가 없음")
    void carInitAndNotMoveForwardWithNumberUnder4(String name, int initial, String expected) {
        Car car = new Car(name, initial);
        car.move(() -> false);
        assertThat(car.showResult()).isEqualTo(expected);
    }
}