package domain;

import static domain.ExceptionMessage.INVALID_TRIAL_COUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.IOHandlerStub;

class RacingGameTest {

    private RacingGame racingGame;
    private IOHandlerStub ioHandlerStub;

    @BeforeEach
    public void setUp() {
        ioHandlerStub = new IOHandlerStub("car1,car2,car3", 5);
        racingGame = new RacingGame(ioHandlerStub);
    }

    @Test
    @DisplayName("자동차 이름을 입력받을 수 있다.")
    public void testAskCarNames() {
        List<String> carNames = racingGame.askCarNames();
        assertEquals(3, carNames.size());
        assertEquals("car1", carNames.get(0));
        assertEquals("car2", carNames.get(1));
        assertEquals("car3", carNames.get(2));
    }

    @Test
    @DisplayName("자동차를 생성할 수 있다.")
    public void testCreateCars() {
        List<String> carNames = racingGame.askCarNames();
        List<String> validatedCarNames = racingGame.validateCarNames(carNames);
        racingGame.createCars(validatedCarNames);
        List<RacingCar> cars = racingGame.getCars();
        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    @DisplayName("자동차 이름을 유효성 검사할 수 있다.")
    public void testValidateCarNames() {
        List<String> carNames = racingGame.askCarNames();
        List<String> validatedCarNames = racingGame.validateCarNames(carNames);
        assertEquals(carNames, validatedCarNames);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상이면 예외를 발생시킨다.")
    public void testValidateCarNamesWithInvalidName() {
        ioHandlerStub = new IOHandlerStub("car1,invalidCarName123,car3", 5);
        racingGame = new RacingGame(ioHandlerStub);
        List<String> carNames = racingGame.askCarNames();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            racingGame.validateCarNames(carNames);
        });
        assertTrue(exception.getMessage().contains(ExceptionMessage.INVALID_NAME_LENGTH.getMessage()));
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외를 발생시킨다.")
    public void testValidateCarNamesWithDuplicatedName() {
        ioHandlerStub = new IOHandlerStub("car1,car1,car3", 5);
        racingGame = new RacingGame(ioHandlerStub);
        List<String> carNames = racingGame.askCarNames();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            racingGame.validateCarNames(carNames);
        });
        assertTrue(exception.getMessage().contains(ExceptionMessage.DUPLICATED_CAR_NAME.getMessage()));
    }


    @Test
    @DisplayName("시도 횟수를 입력받을 수 있다.")
    public void testAskTrialCount() {
        racingGame.setTrialCount();
        assertEquals(5, racingGame.getTrialCount());
    }

    @Test
    @DisplayName("시도 횟수가 유효하지 않으면 예외를 발생시킨다.")
    public void testAskTrialCountWithInvalidInput() {
        ioHandlerStub = new IOHandlerStub("car1,car2,car3", 0);
        racingGame = new RacingGame(ioHandlerStub);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            racingGame.setTrialCount();
        });
        assertTrue(exception.getMessage().contains(INVALID_TRIAL_COUNT.getMessage()));
    }
}
