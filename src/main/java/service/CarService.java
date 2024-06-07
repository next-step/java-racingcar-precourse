package service;

import model.Car;
import model.CarModelInterface;

public class CarService implements CarServiceInterface {

    private CarModelInterface car;

    // 생성자
    public CarService(String name, int progress) {
        car = new Car(name, progress);
    }

    public void goForward() {

    }

    @Override
    public String getName() {
        return car.getName();
    }

    @Override
    public int getProgress() {
        return car.getProgress();
    }

    @Override
    public void moveOrNot() {

    }
}
