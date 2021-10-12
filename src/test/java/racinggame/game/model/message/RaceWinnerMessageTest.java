package racinggame.game.model.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.game.model.car.CarNames;

import static org.assertj.core.api.Assertions.assertThat;

class RaceWinnerMessageTest {


    @DisplayName("우승 메세지 비교 테스트")
    @ParameterizedTest
    @CsvSource({
            "'ab,cd', '최종 우승자는 ab,cd 입니다.'",
            "'ab', '최종 우승자는 ab 입니다.'",
    })
    void testMakeCarNames(String inputValue, String result) {
        CarNames carNames = new CarNames(inputValue);
        RaceWinnerMessage raceWinnerMessage = new RaceWinnerMessage(carNames.getCarNames());
        assertThat(result.equals(raceWinnerMessage.getMessage())).isTrue();
    }


}