package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarPositionTest {

    static IntStream someZeroOrPositiveIntegerStream() {
        int rangeSize = 5;
        return IntStream.range(CarPosition.CAR_START_POSITION, rangeSize);
    }

    static IntStream someMinusIntegerStream() {
        int rangeSize = 5;
        return IntStream.range(CarPosition.CAR_START_POSITION - rangeSize, CarPosition.CAR_START_POSITION);
    }

    @Test
    @DisplayName("자동차 위치 초기화가 정상적으로 이루어지는지 확인한다.")
    void initTest() {
        // given
        int expectedCarStartPosition = 0;

        // when
        CarPosition carPosition = CarPosition.init();

        //then
        assertThat(carPosition.getPosition()).as("자동차 시작 위치가 기대한 값과 일치하는지 확인")
                .isEqualTo(expectedCarStartPosition);

        assertThat(CarPosition.CAR_START_POSITION).as("자동차 시작 위치가 의도한 값으로 설정되어있는지 확인.")
                .isEqualTo(expectedCarStartPosition);
    }

    @ParameterizedTest(name = "자동차 위치가 정상적으로 생성되는지 확인한다. [자동차 위치 : {0}]")
    @MethodSource("someZeroOrPositiveIntegerStream")
    void fromTest(int position) {
        // when
        CarPosition carPosition = CarPosition.from(position);

        //then
        assertThat(carPosition.getPosition()).as("자동차 시작 위치가 기대한 값과 일치하는지 확인")
                .isEqualTo(position);
    }

    @ParameterizedTest(name = "(예외 테스트) 자동차 위치의 범위를 벗어난 경우(0 미만) IllegalArgumentException이 발생한다. [자동차 위치 : {0}]")
    @MethodSource("someMinusIntegerStream")
    void exception(int minusPosition) {
        //then
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        // when
                        () -> CarPosition.from(minusPosition)
                )
                .withMessage("자동차 위치는 %d보다 작을 수 없습니다.", CarPosition.CAR_START_POSITION);
    }

    @ParameterizedTest(name = "자동차 위치가 1씩 증가하는지 확인한다. [증가 횟수 : {0}]")
    @MethodSource("someZeroOrPositiveIntegerStream")
    void increaseTest(int count) {
        // given
        CarPosition carPosition = CarPosition.init();

        // when
        carPosition.increase(count);

        //then
        assertThat(carPosition.getPosition()).as("자동차 위치 증가 횟 수 만큼 위치값이 증가했는지 확인")
                .isEqualTo(count);
    }
}