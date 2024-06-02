import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import model.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameService;

public class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    @DisplayName("유효한 자동차 입력 테스트")
    void validCarNameTest() {
        // given
        String validCarNames = "car1,car2,car3";

        // when
        boolean isValid = gameService.validateCarNames(validCarNames);

        // then
        assertTrue(isValid);
    }

    @Test
    @DisplayName("유효하지 않은 자동차 입력 테스트 - 5자 이상의 자동차명")
    void over5DigitCarNameTest() {
        // given
        String invalidCarNames = "carName1,carName2,carName3";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.validateCarNames(invalidCarNames);
        });

        assertEquals("자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 자동차 입력 테스트 - 자동차명 입력 없음")
    void emptyCarNameInputTest() {
        // given
        String invalidCarNames = "";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.validateCarNames(invalidCarNames);
        });

        assertEquals("자동차 이름을 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 자동차 입력 테스트 - 공백의 자동차명 입력")
    void emptyCarNameTest() {
        // given
        String invalidCarNames = "car1,,car2";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.validateCarNames(invalidCarNames);
        });

        assertEquals("자동차 이름은 비워둘 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void testCreateCarList() {
        // given
        String carNames = "car1,car2,car3";

        // when
        List<RacingCar> carList = gameService.createCarList(carNames);

        // then
        assertEquals(3, carList.size());
        assertEquals("car1", carList.get(0).getCarName());
        assertEquals("car2", carList.get(1).getCarName());
        assertEquals("car3", carList.get(2).getCarName());
    }

    @Test
    @DisplayName("유효한 시도 횟수 테스트")
    void validRoundsTest() {
        //given
        int inputRounds = 3;

        //when, then
        assertTrue(gameService.validateRounds(inputRounds));
    }

    @Test
    @DisplayName("유효하지 않은 시도 횟수 테스트")
    void invalidRoundsTest() {
        //given
        int inputRounds = -1;

        //when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameService.validateRounds(inputRounds);
        });
        assertEquals("시도 횟수는 0보다 커야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("난수 생성 범위 테스트")
    void generateCarRandomNumTest() {
        //given
        RacingCar car = new RacingCar(0, "testCar");

        //when
        int randomNumber = gameService.generateCarRandomNum(car);

        //then
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    @DisplayName("자동차 이동 테스트 - 난수값이 4 이상")
    void determineCarMoveTest() {
        //given
        int randomNum = 6;
        RacingCar car = new RacingCar(0, "testCar");

        //when
        gameService.determineCarMove(randomNum, car);

        //then
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이동 테스트 - 난수값이 4 미만")
    void determineCarStopTest() {
        //given
        int randomNum = 3;
        RacingCar car = new RacingCar(0, "testCar");

        //when
        gameService.determineCarMove(randomNum, car);

        //then
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("최고 점수 찾기 테스트")
    void getMaxPositionTest() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(3, "Car1"));
        racingCars.add(new RacingCar(1, "Car2"));
        racingCars.add(new RacingCar(5, "Car3"));
        racingCars.add(new RacingCar(7, "Car4"));

        // when
        int maxPosition = gameService.getMaxPosition(racingCars);

        // then
        assertEquals(7, maxPosition);
    }

    @Test
    @DisplayName("우승자 판단 테스트")
    void determineWinnerTest() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(3, "Car1"));
        racingCars.add(new RacingCar(7, "Car2"));
        racingCars.add(new RacingCar(2, "Car3"));
        racingCars.add(new RacingCar(7, "Car4"));

        // when
        List<String> winners = gameService.determineWinner(racingCars, 7);

        // then
        assertEquals(2, winners.size());
        assertEquals("Car2", winners.get(0));
        assertEquals("Car4", winners.get(1));
    }
}
