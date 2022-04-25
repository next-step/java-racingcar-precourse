package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.common.CommonVariable.ERROR_MESSAGE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_RACING_CAR_NAME_IS_OVER_SIX;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @DisplayName("레이싱카 생성 테스트 - 실패(이름없음)")
    @Test
    void createRacingCarValidationTestToFailAtNullName(){
        // given
        String name = "";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    RacingCar racingcar = RacingCar.getInstance(name);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);
    }

    @DisplayName("레이싱카 생성 테스트 - 실패(이름5자초과)")
    @Test
    void createRacingCarValidationTestToFailAtOver5Name(){
        // given
        String name = "racingCar";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    RacingCar racingcar = RacingCar.getInstance(name);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_RACING_CAR_NAME_IS_OVER_SIX);
    }

    @DisplayName("레이싱카 생성 테스트 - 성공")
    @Test
    void createRacingCarValidationTestToSuccess(){
        // given
        String name = "jimi";

        // when
        RacingCar racingcar = RacingCar.getInstance(name);

        // then
        assertEquals(racingcar.getName(), name);

    }

    @DisplayName("레이싱카 생성 후 주행테스트 랜덤값 3이하면 0을 랜덤값 4이상 9이하이면 그대로 반영 - 10번 테스트 랜덤값")
    @ParameterizedTest
    @CsvSource(value = {"jimi", "aimi", "bimi", "cimi", "dimi", "eimi", "fimi", "gimi", "himi", "kimi"})
    void createRacingCarRacingTest(String name){

        // when
        RacingCar racingcar = RacingCar.getInstance(name);
        racingcar.runRacing();
        final int travel = racingcar.getTravel();
        assertTrue(travel == 0 || travel == 1);
    }

}