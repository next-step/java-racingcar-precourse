package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @DisplayName("자동차를_생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "sung", "woo"})
    void 자동차를_생성한다(String name) {
        assertThatCode(() -> {
            RacingCar car = new RacingCar(name);
            System.out.println(car.information());
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차를_생산할_수_없다")
    @ParameterizedTest
    @NullSource
    void 자동차를_생산할_수_없다(String name) {
        assertThatThrownBy(() -> {
            RacingCar car = new RacingCar(name);
            System.out.println(car.information());
        }).isInstanceOfAny(NullPointerException.class);
    }

    @DisplayName("자동차를_전진한다")
    @ParameterizedTest
    @MethodSource("전진_가능한_숫자와_이름을_제공한다")
    void 자동차를_전진한다(int inclusiveStart, int inclusiveEnd, String name) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);
        int integer = generator.pickRandomIntegerInRange();
        RacingCar car = new RacingCar(name);
        car.moveForward(integer);

        int defaultDistance = 0;
        assertThat(car.distance()).isEqualTo(defaultDistance + 1);
    }

    static Stream<Arguments> 전진_가능한_숫자와_이름을_제공한다() {
        return Stream.of(
                Arguments.of(4, 9, "ford"),
                Arguments.of(5, 9, "gm"),
                Arguments.of(6, 9, "tesla"),
                Arguments.of(9, 9, "ford")
        );
    }

    @DisplayName("자동차를_멈춘다")
    @ParameterizedTest
    @MethodSource("전진_불가능한_숫자와_이름을_제공한다")
    void 자동차를_멈춘다(int inclusiveStart, int inclusiveEnd, String name) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);
        int integer = generator.pickRandomIntegerInRange();
        RacingCar car = new RacingCar(name);
        car.moveForward(integer);

        int defaultDistance = 0;
        assertThat(car.distance()).isEqualTo(defaultDistance);
    }

    static Stream<Arguments> 전진_불가능한_숫자와_이름을_제공한다() {
        return Stream.of(
                Arguments.of(0, 3, "ford"),
                Arguments.of(1, 3, "gm"),
                Arguments.of(2, 3, "tesla"),
                Arguments.of(3, 3, "ford")
        );
    }
}
