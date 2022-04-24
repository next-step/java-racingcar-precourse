package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import racingcar.utils.RandomNumberUtils;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

class RacingCarPlayServiceTest {

    private static final int FORWARD = 9;
    private static final int STOP = 1;

    private RacingCarPlayService racingCarPlayService;

    @BeforeEach
    void before() {
        racingCarPlayService = new RacingCarPlayService();
    }


    @DisplayName("입력받은 자동차이름(문자열)에 대한 자동차 목록 생성")
    @ParameterizedTest
    @CsvSource(value = "볼보,1등카,빨라용:3", delimiter = ':')
    void registerRacingCars(String inputCarNames) {
        RacingCars racingCars = racingCarPlayService.registerRacingCars(inputCarNames);
        List<RacingCar> racingCarList = racingCars.getRacingCarList();

        int idx = 0;
        for (String expectedCarName : inputCarNames.split(",")) {
            String actualCarName = racingCarList.get(idx++).getCarName();
            assertEquals(expectedCarName, actualCarName);
        }
    }

    @DisplayName("자동차 경주게임 플레이(우승자 확인)")
    @Test
    void proceedGame() {
        String round = "3";
        int expectedWinnerCount = 1;
        int winner = 0;
        String expectedWinnerCarName = "한국팀";

        RacingCars racingCars = new RacingCars(Arrays.asList("미국팀", "한국팀", "독일팀"));

        try (final MockedStatic<RandomNumberUtils> mock = mockStatic(RandomNumberUtils.class)) {
            when(RandomNumberUtils.getRandomNumberFromZeroToNine())
                    .thenReturn(FORWARD, FORWARD, STOP,
                            STOP, FORWARD, FORWARD,
                            FORWARD, FORWARD, STOP);

            racingCars = racingCarPlayService.proceedGame(racingCars, round);
            List<RacingCar> winnerCarList = racingCars.getGameWinnerList();

            assertEquals(expectedWinnerCount, winnerCarList.size());
            assertEquals(expectedWinnerCarName, winnerCarList.get(winner).getCarName());
        }
    }


    @DisplayName("시도 횟수 입력값 예외 처리 검증(숫자가 아닌경우)")
    @ParameterizedTest(name = "round 입력 값이 [{0}]")
    @ValueSource(strings = {"$", "일", "!", "-1", "0"})
    void proceedGame_throw_not_number(String round) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCarPlayService.proceedGame(null, round))
                .withMessage("[ERROR] 시도 횟수는 1이상의 숫자여야 합니다.");

    }

    @DisplayName("시도 횟수 입력값 예외 처리 검증(범위가 너무 큰 경우)")
    @Test
    void proceedGame_throw_not_range() {
        String round = "10000000000000";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCarPlayService.proceedGame(null, round))
                .withMessage("[ERROR] 시도 횟수가 너무 많습니다.");
    }

}