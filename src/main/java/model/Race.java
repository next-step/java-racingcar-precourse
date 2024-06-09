package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars;
    private final int iterNum;
    private final Random random;

    public Race(List<String> names, int iterNum) {
        this.iterNum = iterNum;
        this.random = new Random();
        this.cars = new ArrayList<>();
        for(String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public void round() {
        for (Car car : cars) {
            int randNum = random.nextInt(10);
            if (randNum >= 4) {
                car.moveFoward();
            }
            System.out.println(car.toString());
        }
        System.out.println();
    }


    public List<String> checkWinner() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
