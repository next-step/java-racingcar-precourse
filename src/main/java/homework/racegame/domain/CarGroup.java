package homework.racegame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    int getMaximumMoveProgressValueInGroup() {
        List<Car> temp = new ArrayList<>(cars);
        Collections.sort(temp,
            (car1, car2) -> (car1.getMoveProgressValue() - car2.getMoveProgressValue()) * -1
        );
        return temp.get(0).getMoveProgressValue();
    }

    void setCarIntoListCheckWithPredicate(Car car, List<Car> carList, Predicate<Car> predicate) {
        if (predicate.test(car)) {
            carList.add(car);
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
        System.out.println();
    }

    public List<Car> getWinners() {
        int size = cars.size();
        int maximumValue = getMaximumMoveProgressValueInGroup();
        List<Car> result = new ArrayList<>();
        Predicate<Car> predicate = car -> car.getMoveProgressValue() >= maximumValue;
        for (int index = 0; index < size; index++) {
            setCarIntoListCheckWithPredicate(cars.get(index), result, predicate);
        }
        return result;
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
