package racingcar.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Application;
import racingcar.racing.RacingCarResult;

class CarTest extends NsTest {

    @ParameterizedTest
    @MethodSource("carNames")
    @DisplayName("자동차 생성 성공 테스트")
    void of(CarName carName) {
        // given

        // when
        final Car car = Car.of(carName);

        // then
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    static Stream<Arguments> carNames() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(CarName.of("pobi")))
                .add(Arguments.of(CarName.of("crong")))
                .add(Arguments.of(CarName.of("honux")))
                .build();
    }

    @Test
    @DisplayName("자동차 생성시 null 입력시 에러 테스트")
    void of_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> Car.of(null))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @MethodSource("carNames")
    @DisplayName("자동차 경주시 전진 혹은 멈춤 테스트")
    void race(CarName carName) {
        // given

        // when
        final Car car = Car.of(carName);

        // then
        assertRandomNumberInRangeTest(() -> {
            assertThat(car.race()).isEqualByComparingTo(RacingCarResult.GO);
        }, Car.GO_NUMBER);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}