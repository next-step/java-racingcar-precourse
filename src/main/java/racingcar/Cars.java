package racingcar;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCar() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(GoStop.getRandomNumber());
        }
    }

    public StringBuilder printCar() {
        StringBuilder gameResult = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            gameResult.append(cars.get(i).getName() + " : " + cars.get(i).getPosition() + "\n");
        }

        return gameResult;
    }
}