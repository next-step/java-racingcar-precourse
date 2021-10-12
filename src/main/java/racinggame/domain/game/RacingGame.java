package racinggame.domain.game;

import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int limitCount;
    List<Car> participationCarList = new ArrayList<>();

    public RacingGame(String[] carNames, int limitCount) {
        this.limitCount = limitCount;
        createCar(carNames); // TODO 명칭 변경 필요
    }

    private void createCar(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            participationCarList.add(car);
        }
    }

    public void gameStart() {


    }

    public void moveCarByNum(Car car, int number) {
        if (isMoveCarByNum(number)) {
            car.moveCar();
        }
    }

    private boolean isMoveCarByNum(int number) {
        return number > 3 && number < 10;
    }


}
