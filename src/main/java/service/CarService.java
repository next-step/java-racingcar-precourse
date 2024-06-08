package service;

import model.Car;
import model.CarModelInterface;

// model과 service를 분리해서 service는 구체적인 로직만 갖도록 함.
public class CarService implements CarServiceInterface {

    private CarModelInterface car;

    // 생성자
    public CarService(String name, int progress) {
        car = new Car(name, progress);
    }

    // 한 칸 앞으로 가는 메서드
    private void goForward() {
        car.setProgress(car.getProgress() + 1);
    }

    // model의 getter
    @Override
    public String getName() {
        return car.getName();
    }

    // model의 getter
    @Override
    public int getProgress() {
        return car.getProgress();
    }

    // 난수 생성 후 앞으로 갈지 말지 결정하는 메서드
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
