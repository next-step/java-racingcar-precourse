import domain.Car;
import util.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameManager {

    private static final int FORWARD_STANDARD = 4;
    private final List<Car> carList;
    private InputValidator inputValidator;
    private int attemptNumber;

    public GameManager() {
        this.carList = new ArrayList<>();
    }

    public void run() {
        initGameSettings();
        ConsoleMessagePrinter.printLineBreak();
        ConsoleMessagePrinter.printExecutionResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            takeOneStepForward();
            printCarList();
        }
        List<String> winnerList = findWinnerNames();
        ConsoleMessagePrinter.printWinnerList(winnerList);
    }

    private List<String> findWinnerNames() {
        List<String> winnerList = new ArrayList<>();
        int winnerAdvanceNumber = carList.stream()
                .max(Comparator.comparingInt(Car::getAdvanceNumber))
                .get()
                .getAdvanceNumber();
        for (Car car : carList) {
            if (car.getAdvanceNumber() == winnerAdvanceNumber) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private void printCarList() {
        for (Car car : carList) {
            ConsoleMessagePrinter.printCarPresentStatus(car);
        }
        ConsoleMessagePrinter.printLineBreak();
    }

    private void takeOneStepForward() {
        int randomNumber;
        for (Car car : carList) {
            randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (randomNumber >= FORWARD_STANDARD) {
                car.advance();
            }
        }
    }

    private void initGameSettings() {
        setCarList();
        setAttemptNumber();
    }

    private void setAttemptNumber() {
        String userInput = null;
        inputValidator = new AttemptNumberValidator();
        while (userInput == null) {
            ConsoleMessagePrinter.printAttemptNumberInputMessage();
            userInput = getUserInput();
        }
        attemptNumber = Integer.parseInt(userInput);
    }

    private void setCarList() {
        String userInput = null;
        inputValidator = new CarNameValidator();
        while (userInput == null) {
            ConsoleMessagePrinter.printCarNameInputMessage();
            userInput = getUserInput();
            if (userInput != null) {
                initCarList(StringSplitter.splitString(userInput));
            }
        }
    }

    private void initCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private String getUserInput() {
        String userInput = null;
        try {
            userInput = InputHandler.getInput();
            inputValidator.checkInputValue(userInput);
        } catch (IllegalArgumentException exception) {
            ConsoleMessagePrinter.printErrorMessage(exception.getMessage());
        }
        return userInput;
    }
}
