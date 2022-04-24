package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.CarConstant;
import racingcar.constant.Constant;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("yoon,lee,kim");
    }

    @ParameterizedTest
    @DisplayName("우승자 선정 테스트")
    @CsvSource(value = {"9,1,2,4,9,2:yoon", "5,5,1:yoon, lee", "5,5,5:yoon, lee, kim"}, delimiter = ':')
    void validateWinnerNamesTest(String input, String expected) {
        // given
        String[] splitCarNumber = input.split(Constant.COLON)[0].split(CarConstant.COMMA);
        List<Car> resultCar = racingGame.getResult().getCarItems();

        // when
        for (int i = 0; i < splitCarNumber.length; i++) {
            Car car = resultCar.get(i % resultCar.size());
            car.move(Integer.parseInt(splitCarNumber[i]));
        }
        String result = Cars.getWinnerNames(racingGame.getResult().getWinnerCars());

        // then
        assertEquals(expected, result);
    }
}
