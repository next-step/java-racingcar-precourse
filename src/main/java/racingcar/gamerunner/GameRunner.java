package racingcar.gamerunner;

import racingcar.dao.Cars;
import racingcar.validator.StringValidator;
import racingcar.vo.Car;
import racingcar.vo.Name;
import racingcar.vo.Position;

public class GameRunner {
    private StringValidator stringValidator;
    private Cars listCars;

    public GameRunner() {
        listCars = new Cars();
        stringValidator = new StringValidator();
    }

    public void startGame() {
        stringValidator.racingReader();

        for (int i = 0; i < stringValidator.getCarNames().length; i++) {
            Position position = new Position();
            position.setStartPosition();
            Name name = new Name(stringValidator.getCarNames()[i]);
            Car car = new Car(name, position);
            listCars.add(car);
        }
        runGame(listCars);
    }

    private void runGame(Cars listCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < stringValidator.getTryTimes(); i++) {
            listCars.carFunction();
        }

        listCars.printWinners();
    }

}
