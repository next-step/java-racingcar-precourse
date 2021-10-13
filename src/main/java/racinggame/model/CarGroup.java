package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> carGroup;

    public CarGroup() {
        carGroup = new ArrayList<>();
    }

    public CarGroup(CarNames names) {
        if (!names.isValidCarNames()) {
            throw new IllegalArgumentException();
        }

        carGroup = new ArrayList<>();
        for(String carName : names.getCarNames()) {
            carGroup.add(new Car(carName));
        }
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }

    public void printCarGroup () {
        for (Car car: carGroup) {
            System.out.println(car.printCarInfo());
        }
        System.out.println();
    }

    public void appendCar(Car car) {
        carGroup.add(car);
    }

    public void removeAll() {
        carGroup.clear();
    }
}
