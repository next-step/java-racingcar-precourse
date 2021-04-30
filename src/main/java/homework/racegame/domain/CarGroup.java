package homework.racegame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveOrStopCars() {
        for (Car car : cars) {
            car.moveOrStop();
        }
    }

    public void printCarsProgress() {
        for (Car car : cars) {
            car.printMoveProgress();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Car car : cars) {
            stringBuffer.append(car.toString()).append("\n");
        }
        return stringBuffer.toString();
    }
}
