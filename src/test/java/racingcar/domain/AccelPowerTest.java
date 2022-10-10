package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AccelPowerTest {
    static IntStream accelPowerIntegerStream() {
        int rangeSize = AccelPower.MAX_POWER - AccelPower.MIN_POWER;
        return IntStream.range(AccelPower.MIN_POWER, rangeSize + 1);
    }

    @ParameterizedTest(name = "악셀 파워가 0~9 구간에서 정상적으로 생성되는지 확인한다. [Accel Power : {0}]")
    @MethodSource("accelPowerIntegerStream")
    void fromTest(int power) {
        // given

        // when
        AccelPower accelPower = AccelPower.from(power);

        //then
        assertThat(accelPower.getPower()).as("값이 정상적으로 들어갔는지 확인")
                .isEqualTo(power);
    }

    @Test
    @DisplayName("랜덤으로 생성한 악셀 파워가 정상적으로 생성되었는지 확인한다.")
    void createRandomTest() {
        // given

        // when
        AccelPower accelPower = AccelPower.byRandom();

        //then
        assertThat(accelPower.getPower() >= AccelPower.MIN_POWER
                && accelPower.getPower() <= AccelPower.MAX_POWER).as("악셀 파워가 정상 범위 내에서 생성되었는지 확인")
                .isTrue();
    }

    @ParameterizedTest(name = "(예외 테스트) 악셀 파워 입력 가능 범위를 벗어난 경우 IllegalArgumentException이 발생한다. [Accel Power : {0}]")
    @ValueSource(ints = {AccelPower.MIN_POWER - 1, AccelPower.MAX_POWER + 1})
    void exceptionTest(int power) {
        //then
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        // when
                        () -> AccelPower.from(power)
                )
                .withMessage(String.format("악셀은 %d~%d사이의 값만 입력 가능합니다.", AccelPower.MIN_POWER, AccelPower.MAX_POWER));


    }

    @ParameterizedTest(name = "입력된 파워에 따른 이동 가능 여부 판단이 정상적으로 수행되는지 확인한다. [Accel Power : {0}, 이동 가능 여부 : {1}]")
    @CsvSource(value = {
            "0,false",
            "1,false",
            "2,false",
            "3,false",
            "4,true",
            "5,true",
            "6,true",
            "7,true",
            "8,true",
            "9,true",
    })
    void isPossibleMove(int power, boolean expectedResult) {
        // given
        AccelPower accelPower = AccelPower.from(power);

        // when
        accelPower.isPossibleMove();

        // then
        assertThat(accelPower.isPossibleMove()).as("이동 가능 여부 비교")
                .isEqualTo(expectedResult);
    }
}