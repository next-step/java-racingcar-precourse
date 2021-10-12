package racinggame.game.console;

import racinggame.game.console.input.CarNameInputConsole;
import racinggame.game.console.input.TryInputConsole;
import racinggame.game.model.car.Car;
import racinggame.game.model.car.CarName;
import racinggame.game.model.car.CarNames;
import racinggame.game.model.message.RaceResultMessage;
import racinggame.game.model.message.RaceWinnerMessage;

import java.util.List;

public class GameConsole {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자리 이하 문자만 입력 가능합니다.(공백 입력 불가)";

    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TRY_ERROR_MESSAGE = "[ERROR] 1이상의 정수만 입력 가능합니다.";

    private static final String RACE_RESULT_TITLE = "실행 결과";
    private static final String WHITE_SPACE_STRING = " ";

    private final CarNameInputConsole carNameInputConsole;
    private final TryInputConsole tryInputConsole;


    public GameConsole() {
        carNameInputConsole = new CarNameInputConsole(CAR_NAME_INPUT_MESSAGE, CAR_NAME_ERROR_MESSAGE);
        tryInputConsole = new TryInputConsole(TRY_INPUT_MESSAGE, TRY_ERROR_MESSAGE);
    }



    public CarNames getCarNames() {
        return carNameInputConsole.getInputValue();
    }

    public int getTryCount() {
        return tryInputConsole.getInputValue();
    }



    public void printRaceResultTitle() {
        System.out.println(WHITE_SPACE_STRING);
        System.out.println(RACE_RESULT_TITLE);
    }

    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            RaceResultMessage raceResultMessage
                    = new RaceResultMessage(car.getCarName().getCarName(), car.getForwardMovementCount());
            System.out.println(raceResultMessage.getMessage());
        }
        System.out.println(WHITE_SPACE_STRING);
    }

    public void printRaceWinners(List<CarName> carNames) {
        RaceWinnerMessage raceWinnerMessage = new RaceWinnerMessage(carNames);
        System.out.println(raceWinnerMessage.getMessage());
    }


}
