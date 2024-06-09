package service;

import model.Car;
import model.CarModelInterface;

// model과 service를 분리해서 service는 비즈니스 로직만 갖도록 함.
public class CarService implements CarServiceInterface {

    private CarModelInterface car;

    // 생성자
    public CarService(String name, int progress) {
        car = new Car(name, progress);
    }

    // getter
    @Override
    public String getName() {
        return car.getName();
    }

    // getter
    @Override
    public int getProgress() {
        return car.getProgress();
    }

    // 비즈니스 로직: 경주하는 차들을 앞으로 보내자.
    @Override
    public void moveOrNot() {
        // 랜덤 변수를 생성한 후
        int randomNumber = (int) (Math.random() * 10);

        // 만약 4 이상이라면
        if (randomNumber > 3) {
            // 앞으로 전진한다.
            car.goForward();
        }
    }
}
