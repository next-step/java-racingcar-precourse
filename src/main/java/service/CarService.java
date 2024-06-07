package service;

import model.Car;
import model.CarModelInterface;

public class CarService implements CarServiceInterface {

    private CarModelInterface car;

    // 생성자
    public CarService(String name, int progress) {
        car = new Car(name, progress);
    }

    private void goForward() {
        car.setProgress(car.getProgress() + 1);
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
        // 랜덤 변수를 생성한 후
        int randomNumber = (int) (Math.random() * 10);

        // 만약 4 이상이라면
        if (randomNumber > 3) {
            // 앞으로 전진한다.
            goForward();
        }
    }
}
