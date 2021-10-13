package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.constants.Messages;
import racinggame.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;
import static racinggame.constants.RacingCarConstants.CAR_NAME_INPUT_DELIMETER;

public class RacingCarCreateTest {
    @ParameterizedTest
    @ValueSource(strings = {"aCar", "12C", "1_Car", "myCar", "!%"})
    @DisplayName("5자이하이름자동차생성테스트")
    void createRacingCarWithFiveDigitNameTest(String userInputCarName) {
        // Given
        RacingCar racingCar = RacingCar.newInstance(userInputCarName);

        // When, Then
        assertThat(racingCar.getRacingCarName()).isEqualTo(userInputCarName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"myCars", "myCar0", "myCar1", "myCar12", "myCar123"})
    @DisplayName("자동차이름생성5자이상예외테스트")
    void createRacingCarNameFiveDigitExceptionTest(String userInputCarName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCar.newInstance(userInputCarName);
        });
    }

    @Test
    @DisplayName("자동차이름생성공백예외테스트")
    void createRacingCarNameBlankExceptionTest() {
        assertThatThrownBy(() -> {
            RacingCar.newInstance("");
            RacingCar.newInstance(" ");
            RacingCar.newInstance("  ");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(Messages.CAR_NAME_BLANK_INVALID.getMessage());
    }

    @Test
    @DisplayName("경주자동차사용자입력n개생성테스트")
    void createRacingCarsByUserInputTest() {
        // Given
        String userInputCarNames = "aCar, bCar, cCar, dCar, eCar";
        String[] carNames = userInputCarNames.split(CAR_NAME_INPUT_DELIMETER);

        // When
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(RacingCar.newInstance(carName));
        }

        // Then
        assertThat(racingCars.size()).isEqualTo(carNames.length);
    }
}
