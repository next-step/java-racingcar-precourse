package racingcar.domain;

import racingcar.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayCars {
    private static final StringBuilder carsStatus = new StringBuilder();

    private final List<Car> cars = new ArrayList<>();
    private int winnerScore;

    public PlayCars(){
    }

    public PlayCars(String carList) {
        String[] carNames = carList.split(Constant.SEPARATOR);

        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getCarsStatus() {
        return carsStatus.toString();
    }

    public void play() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        for (Car car : cars) {
            car.isMove(randomMovingStrategy);
            checkWinnerScore(car);
            carsStatus.append(car.getCarName() + Constant.COLON + car.showCarDistance());
            carsStatus.append("\n");
        }
        carsStatus.append("\n");
    }

    private void checkWinnerScore(Car car) {
        if(winnerScore < car.getDistance()){
            winnerScore = car.getDistance();
        }
    }

    public List<Car> isWinners() {
        for (Car car : cars) {
            checkWinnerScore(car);
        }
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            checkWinnerCar(winnerCars, car);
        }
        return Collections.unmodifiableList(winnerCars);
    }

    private void checkWinnerCar(List<Car> winnerCars, Car car) {
        if(car.isWinner(winnerScore)){
            winnerCars.add(car);
        }
    }
}
