package be.kooru;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final List<Car> cars;

    public CarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void start() {
        for (Car car : cars) {
            addCarScore(car);
            printCarScore(car);
        }
        System.out.println();
    }

    protected void addCarScore(Car car) {
        int randomNumber = Util.generateRandomNumber(1, 0, 9)[0];
        car.addScore(randomNumber);
    }

    protected void printCarScore(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(":");
        for (int i = 0; i < car.getScore(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    protected List<String> maxScoreCarList() {
        List<String> tempCars = new ArrayList<>();
        int maxNumber = 0;

        for (Car car : cars) {
            if (maxNumber == car.getScore()) {
                tempCars.add(car.getName());
            }
            if (maxNumber < car.getScore()) {
                tempCars = new ArrayList<>();
                tempCars.add(car.getName());
                maxNumber = car.getScore();
            }
        }
        return tempCars;
    }

    public void printCarWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", maxScoreCarList()))
                .append("가 최종우승했습니다.");
        System.out.println(sb.toString());
    }
}
