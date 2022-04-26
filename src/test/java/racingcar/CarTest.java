package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.cars.Car;
import racingcar.firstcollections.Positive;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @ParameterizedTest
    @DisplayName("전진 기능 (멈춤 : 0 ~ 3, 전진 : 4 ~ 9)")
    @CsvSource(value = {"1, 0", "4, 1", "2, 0", "5, 1"})
    public void test01(int randomNumber, int expected) {
        String input = "test";
        Car car = new Car(input);
        car.move(randomNumber);
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 생성")
    @CsvSource(value = {"홍길동, 홍길동", "4, 4", "ㄱ ㄱ, ㄱ ㄱ", "아아, 아아"})
    public void test02(String input, String expected) {
        Car car = new Car(input);
        assertThat(car.getName().equals(expected)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("잘못된 자동차 이름 생성")
    @MethodSource("provideCarNames")
    public void test03(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

    @ParameterizedTest
    @MethodSource("provideCars")
    @DisplayName("자동차 위치 조회")
    public void test04(Car car, long expected) {
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("  ")
        );
    }

    private static Stream<Arguments> provideCars() {
        return Stream.of(
                Arguments.of(new Car("홍길동", new Positive(2L)), 2L),
                Arguments.of(new Car("pobi", new Positive(0L)), 0L),
                Arguments.of(new Car("jun", new Positive(1L)), 1L)
        );
    }
}
