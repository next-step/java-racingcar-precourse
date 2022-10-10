package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InfoMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameNumber;
import racingcar.model.UserInput;

public class RaceView {
    private UserInput getUserInput() {
        return new UserInput(Console.readLine());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public UserInput askQuestionWithMessage(String question) {
        printMessage(question);
        return getUserInput();
    }

    public void displayStatus(Cars cars) {
        for (Car car : cars.getValue()) {
            System.out.printf("%s : %s%n", car.getName().getValue(), car.getPositionInDashes());
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        this.printMessage(String.format("%s %s", InfoMessage.WINNER, winners));
    }

    public void reportCurrentStatus(GameNumber gameNumber, Cars cars) {
        for (int i = 0; i < gameNumber.getValue(); i++) {
            displayStatus(cars);
        }
    }

}
