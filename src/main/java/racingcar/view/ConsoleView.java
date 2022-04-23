package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.MessageConstants;
import racingcar.domain.AttemptsNumber;
import racingcar.domain.Car;
import racingcar.domain.CarNamesInput;
import racingcar.domain.Cars;
import racingcar.domain.IndexNumber;
import racingcar.domain.Winners;

public class ConsoleView {
    public CarNamesInput readCarNamesInput() {
        System.out.println(MessageConstants.CONSOLE_MESSAGE_CAR_NAMES);

        String inputValue = Console.readLine();
        return new CarNamesInput(inputValue);
    }

    public AttemptsNumber readAttemptsNumber() {
        System.out.println(MessageConstants.CONSOLE_MESSAGE_ATTEMPTS_NUMBER);

        String inputValue = Console.readLine();
        return new AttemptsNumber(inputValue);
    }

    public void printRaceStart() {
        System.out.println();
        System.out.println(MessageConstants.CONSOLE_MESSAGE_RACE_RESULT);
    }

    public void printCurrentCarsPosition(Cars cars) {
        for (IndexNumber index = new IndexNumber(); index.getIndexNumber() < cars.size(); index.increaseIndex()) {
            printCarPosition(cars.get(index));
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getCarName().getName()).append(MessageConstants.SEPARATOR_CAR_POSITION);

        for (IndexNumber index = new IndexNumber(); index.getIndexNumber() < car.getCarPosition().getPosition();
             index.increaseIndex()) {
            stringBuilder.append(MessageConstants.SIGN_CAR_POSITION);
        }

        System.out.println(stringBuilder);
    }

    public void printWinners(Winners winners) {
        System.out.print(MessageConstants.CONSOLE_MESSAGE_RACE_WINNER);

        for (IndexNumber indexNumber = new IndexNumber(); indexNumber.getIndexNumber() < winners.size();
             indexNumber.increaseIndex()) {
            printWinnerCarName(winners, indexNumber);
        }
        System.out.println();
    }

    private void printWinnerCarName(Winners winners, IndexNumber indexNumber) {
        if(indexNumber.getIndexNumber() != 0) {
            System.out.print(MessageConstants.SEPARATOR_WINNER);
        }

        System.out.print(winners.get(indexNumber).getName());
    }


}
