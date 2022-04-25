package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("사용자 이름 comma로 구분 입력")
    void inputRacingGameNamesTest(){
        //given
        RacingGame racingGame = new RacingGame("1,2,3","3");

        //when
        List<RacingCar> racingCars = racingGame.getRacingCars().getRacingCars();

        //then
        assertThat(racingCars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 이름 입력 성공 Validation")
    void inputRacingGameNamesValidTest(){
        //given
        String inputName = "1,2,3";

        //when
        boolean result = ValidationUtil.checkRacingGameNameInput(inputName);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자 이름 입력 실패 Validation")
    void inputRacingGameNamesInValidTest(){
        //given
        String inputName = "pobi,javajigi";

        //when
        boolean result = ValidationUtil.checkRacingGameNameInput(inputName);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("게임 횟수 입력")
    void gameCountTest(){
        //given
        RacingGame racingGame = new RacingGame("1,2,3","1");

        //when
        int gameCount = racingGame.getGameCount();

        //then
        assertThat(gameCount).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 횟수 숫자 포멧 성공 체크")
    void gameCountValidTest(){
        //given
        String inputGameCount = "2";

        boolean result = ValidationUtil.checkGameCount(inputGameCount);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 횟수 숫자 포멧 실패 체크")
    void gameCountInValidTest(){
        //given
        String inputGameCount = "test";

        boolean result = ValidationUtil.checkGameCount(inputGameCount);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("각 자동차 횟수 만큼 racing")
    void runGameRacingCarByGameCountTest(){
        //given
        RacingGame racingGame = new RacingGame("pobi,crong,honux","5");

        //when
        racingGame.runRace();
    }

    @Test
    @DisplayName("게임 우승자 결정")
    void racingGameResultTest(){
        //given
        RacingGame racingGame = new RacingGame("pobi,crong,honux","5");

        //when
        racingGame.runRace();

        racingGame.getRacingResult();
    }
}