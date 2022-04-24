package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.type.CarMovingStatusType;

class CarBehaviorTest {

    @BeforeAll
    static void 초기값_셋팅() {
        RACING_CAR_MOVING_RANGE_VALUE_MIN = 0;
        RACING_CAR_MOVING_RANGE_VALUE_MAX = 9;
        RACING_CAR_MOVING_STANDARD_VALUE = 4;
    }

    @ParameterizedTest
    @DisplayName("자동차가 움직일 여부를 체크할 랜덤 숫자가 설정값 사이의 숫자인지 확인한다.")
    @ValueSource(ints = {-1, 10})
    public void 자동차가_움직일_숫자가_설정값_사이의_숫자인지(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarBehavior(input));
    }

    @ParameterizedTest
    @DisplayName("현재 자동차가 움직여야하는지 상태값 반환")
    @MethodSource("providerArgumentsForReturnMovingStatusType")
    public void 자동차가_움직일지_상태값_반환(int generatedNumber, CarMovingStatusType expectedCarMovingStatusType) {
        CarBehavior carBehavior = new CarBehavior(generatedNumber);
        assertEquals(carBehavior.getMovingStatusType(), expectedCarMovingStatusType);
    }

    private static Stream<Arguments> providerArgumentsForReturnMovingStatusType() {
        return Stream.of(
            Arguments.of(3, CarMovingStatusType.NONE),
            Arguments.of(4, CarMovingStatusType.MOVING)
        );
    }

}
