package service;

import entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameService {
    private List<Car> cars;
    private int raceCount;
    private Random random;

    public GameService() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }
    public void setup(String[] names, int count) {
        this.cars.clear(); // Clear existing cars
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }
            this.cars.add(new Car(name.trim()));
        }
        this.raceCount = count;
    }


    public void startRacing() {
        System.out.println("실행 결과");
        for (int i = 0;i < this.raceCount ; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) {
                    car.move();
                }
                System.out.println(car);
            }
            System.out.println();
        }
    }

    public String getResults() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return "최종 우승자: " + String.join(", ", winners);
    }
}
