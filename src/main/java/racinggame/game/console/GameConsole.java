package racinggame.game.console;

import racinggame.game.car.Car;
import racinggame.game.console.input.CarNameInputConsole;
import racinggame.game.console.input.TryInputConsole;

import java.util.List;

public class GameConsole {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자리 이하 문자만 입력 가능합니다.(공백 입력 불가)";

    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TRY_ERROR_MESSAGE = "[ERROR] 1이상의 정수만 입력 가능합니다.";

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_DELIMITER = ",";

    private static final String RACE_RESULT_TITLE = "실행 결과";
    private static final String WHITE_SPACE_STRING = " ";

    private final CarNameInputConsole carNameInputConsole;
    private final TryInputConsole tryInputConsole;


    public GameConsole() {
        carNameInputConsole = new CarNameInputConsole(
                CAR_NAME_INPUT_MESSAGE, CAR_NAME_ERROR_MESSAGE, CAR_NAME_MAX_LENGTH, CAR_NAME_DELIMITER
        );
        tryInputConsole = new TryInputConsole(TRY_INPUT_MESSAGE, TRY_ERROR_MESSAGE);
    }



    public List<String> getCarNames() {
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
            String carRaceResultMessage = makeCarRaceResultMessage(car.getName(), car.getForwardMovementCount());
            System.out.println(carRaceResultMessage);
        }
        System.out.println(WHITE_SPACE_STRING);
    }

    public void printRaceWinners(List<String> carNames) {
        String winnerMessage = makeCarRaceWinnerMessage(carNames);
        System.out.println(winnerMessage);
    }

    private String makeCarRaceResultMessage(String carName, int forwardMovementCount) {
        StringBuilder stringBuilder = new StringBuilder(carName + " : ");
        for (int i = 0; i < forwardMovementCount; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    private String makeCarRaceWinnerMessage(List<String> carNames) {
        StringBuilder stringBuilder = new StringBuilder("최종 우승자는 ");
        for (String carName : carNames) {
            stringBuilder.append(carName).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() -1);
        stringBuilder.append(" 입니다.");
        return stringBuilder.toString();
    }


}
