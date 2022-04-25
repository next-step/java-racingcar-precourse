package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.common.CommonVariable.ERROR_MESSAGE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_SAME_RACING_CAR_NAME;

import java.util.Arrays;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarManager;

public class RacingCarFactoryTest {

    @DisplayName("게임 참가자 입력 테스트 - 실패(입력값없음)")
    @Test
    void racingGameJoinTestToFailAtInputIsNull(){
        // given
        String input = "";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    CarManager rcf =new CarManager() ;
                    rcf.startRacingGame(input);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);

    }

    @DisplayName("게임 참가자 입력 테스트 - 실패(자동차이름중복)")
    @Test
    void racingGameJoinTestToFailAtNameIsOverlap(){
        // given
        String input = "pobi,pobi,pobi";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    CarManager rcf =new CarManager() ;
                    rcf.startRacingGame(input);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_SAME_RACING_CAR_NAME);

    }

    @DisplayName("게임 참가자 입력 테스트 - 성공")
    @Test
    void createRacingCarValidationTestToSuccess(){
        // given
        String input = "jimi,pobi,chris";

        // when
        CarManager rcf =new CarManager() ;
        rcf.startRacingGame(input);

        // then
        assertEquals(rcf.getJoinRacingCarsMap().keySet(),
                Sets.newHashSet(Arrays.asList(input.split(","))));
    }
}