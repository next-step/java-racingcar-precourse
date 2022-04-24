package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private int maxScore;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void doRound() {
        for (int i = 0; i < getCars().size(); i++) {
            cars.get(i).doRound();
        }
        setMaxScore();
    }

    public void setMaxScore() {
        this.maxScore = Collections.max(getCars(), Comparator.comparingInt(Car::getPosition)).getPosition();
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public String getCarsStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getCars().size(); i++) {
            sb.append(cars.get(i).getCurrentStatus()).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String getWinnersName(int maxScore) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < getCars().size(); i++) {
            checkAndAddWinner(cars.get(i), maxScore, names);
        }
        return String.join(", ", names);
    }

    private void checkAndAddWinner(Car car, int maxScore, List<String> names) {
        if (car.getPosition() == maxScore) {
            names.add(car.getName());
        }
    }
}
