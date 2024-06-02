package domain;

import util.AttemptNumberValidator;
import util.CarNameValidator;
import util.ConsoleMessagePrinter;
import util.InputHandler;
import util.InputValidator;
import util.RandomNumberGenerator;
import util.StringSplitter;

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
        printGameExecutionMessage();
        runGameLogic();
        findAndPrintWinnerNameList();
    }

    private void initGameSettings() {
        setCarList();
        setAttemptNumber();
    }

    private void printGameExecutionMessage() {
        ConsoleMessagePrinter.printLineBreak();
        ConsoleMessagePrinter.printExecutionResultMessage();
    }

    private void runGameLogic() {
        for (int i = 0; i < attemptNumber; i++) {
            takeOneStepForward();
            printCarList();
        }
    }

    private void findAndPrintWinnerNameList() {
        ConsoleMessagePrinter.printWinnerNameList(findWinnerNameList());
    }

    private void setCarList() {
        List<String> carNameList = null;
        while (carNameList == null) {
            carNameList = getCarNameList();
        }
        initCarList(carNameList);
    }

    private List<String> getCarNameList() {
        ConsoleMessagePrinter.printCarNameInputMessage();
        List<String> carNameList = StringSplitter.splitString(InputHandler.getInput());
        if (isCarNameListCorrect(carNameList)) {
            return carNameList;
        }
        return null;
    }

    private boolean isCarNameListCorrect(List<String> carNameList) {
        inputValidator = new CarNameValidator();
        try {
            ((CarNameValidator) inputValidator).checkCarNameList(carNameList);
        } catch (IllegalArgumentException exception) {
            ConsoleMessagePrinter.printErrorMessage(exception.getMessage());
            return false;
        }
        return true;
    }

    private void initCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private void setAttemptNumber() {
        String userInput = null;
        inputValidator = new AttemptNumberValidator();
        while (userInput == null) {
            ConsoleMessagePrinter.printAttemptNumberInputMessage();
            try {
                userInput = InputHandler.getInput();
                inputValidator.checkInputValue(userInput);
            } catch (IllegalArgumentException exception) {
                ConsoleMessagePrinter.printErrorMessage(exception.getMessage());
                userInput = null;
            }
        }
        attemptNumber = Integer.parseInt(userInput);
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

    private void printCarList() {
        for (Car car : carList) {
            ConsoleMessagePrinter.printCarStatus(car.getName(), car.getStatus());
        }
        ConsoleMessagePrinter.printLineBreak();
    }

    private List<String> findWinnerNameList() {
        List<String> winnerNameList = new ArrayList<>();
        int winnerAdvanceNumber = getMaxAdvanceNumber();
        for (Car car : carList) {
            if (car.getAdvanceNumber() == winnerAdvanceNumber) {
                winnerNameList.add(car.getName());
            }
        }
        return winnerNameList;
    }

    private int getMaxAdvanceNumber() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getAdvanceNumber))
                .get()
                .getAdvanceNumber();
    }
}
