package racingcar.domain;

import racingcar.message.RacingCarInfoMessage;
import racingcar.ui.UserInterface;

import java.util.List;

public class RacingCar {

    private static final String LINE_BREAK = "\n";

    private final UserInterface userInterface;
    private Cars cars;
    private NumberOfRace numberOfRace;

    public RacingCar(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start() {
        init();
        process();
    }

    private void init() {
        inputCarNames();
        inputNumberOfRace();
    }

    private void inputCarNames() {
        userInterface.output(RacingCarInfoMessage.INPUT_CAR_NAMES_INFO.getMessage() + LINE_BREAK);
        String carNames = userInterface.input();
        try {
            cars = new Cars(carNames);
        } catch (IllegalArgumentException e) {
            userInterface.output(e.getMessage() + LINE_BREAK);
            inputCarNames();
        }
    }

    private void inputNumberOfRace() {
        userInterface.output(RacingCarInfoMessage.INPUT_NUMBER_OF_RACE.getMessage() + LINE_BREAK);
        String numbers = userInterface.input();
        try {
            numberOfRace = new NumberOfRace(numbers);
        } catch (IllegalArgumentException e) {
            userInterface.output(e.getMessage() + LINE_BREAK);
            inputNumberOfRace();
        }
    }

    private void process() {
        userInterface.output(RacingCarInfoMessage.OUTPUT_RESULT.getMessage() + LINE_BREAK);
        int numberOfRaceInt = numberOfRace.getNumberOfRace();
        for (int i = 0; i < numberOfRaceInt; i++) {
            cars.drive();
            userInterface.output(cars.toString() + LINE_BREAK);
            userInterface.output(LINE_BREAK);
        }
        end();
    }

    private void end() {
        List<String> firstPlaceCarNameList = cars.getFirstPlaceCarNameList();
        userInterface.output(RacingCarInfoMessage.OUTPUT_WINNER.getMessage());
        userInterface.output(String.join(", ", firstPlaceCarNameList) + LINE_BREAK);
    }

}
