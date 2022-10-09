package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.SEPERATOR;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("one,two,three");
    }

    @ParameterizedTest
    @DisplayName("우승자 선정 테스트")
    @CsvSource(value = {"3,4,1:two", "8,4,3:one, two", "0,3,4:three"}, delimiter = ':')
    void validateWinnerNamesTest(String input, String expected) {
        String[] splitCarNumber = input.split(COLON)[0].split(SEPERATOR);
        List<Car> resultCar = racingGame.getCars().getCarList();

        for (int i = 0; i < splitCarNumber.length; i++) {
            Car car = resultCar.get(i % resultCar.size());
            car.move(Integer.parseInt(splitCarNumber[i]));
        }
        String result = Cars.getWinnerCarName(racingGame.getWinner());

        assertEquals(expected, result);
    }
}
