package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.constants.RacingCarConstants.CAR_NAME_INPUT_DELIMETER;

public class RacingCarGameTest {
    @Test
    @DisplayName("랜덤생성이동조건수를이용하여n번입력만큼자동차레이싱게임테스트")
    void moveCarByConditionNumberTest() {
        // Given
        String userInputCarNames = "aCar, bCar, cCar, dCar, eCar";
        String[] carNames = userInputCarNames.split(CAR_NAME_INPUT_DELIMETER);

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            RacingCar racingCar = RacingCar.newInstance(carName);
            racingCars.add(racingCar);
        }

        // When
        int moveTryCount = 7;
        RacingCarGame gameResult = new RacingCarGame(racingCars,moveTryCount);

        List<String> winners = gameResult.getWinners();
        String result = String.join(",", winners);

        // Then
        assertThat(winners.size()).isGreaterThan(0);
    }
}