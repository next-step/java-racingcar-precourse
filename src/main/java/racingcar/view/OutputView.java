package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingSystem;

public class OutputView {

    PrintMessage printMessage = new PrintMessage();
    public void resultMovingString(RacingSystem racingSystem) {
        for (Car car : racingSystem.getCars()) {
            System.out.println(car.getName() + " : " + makeResult(car));
        }
    }

    public String makeResult(Car car) {
        String result = "";

        for (int i = 0; i < car.getPosition(); i++) {
            result += "-";
        }

        return result;
    }

    public void finalVictoryCarString(RacingSystem racingSystem) {
        System.out.println( printMessage.printFinalVictoryCarName() + racingSystem.getVictoryCars(racingSystem.getCars()));
    }
}
