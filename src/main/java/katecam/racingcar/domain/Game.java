package katecam.racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;
    private final int numberToAttempt;
    private int attemptedNumber;
    private final Random random;

    public Game(List<String> carNames, int carNumber) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.numberToAttempt = carNumber;
        this.random = new Random();
    }

    //UnmodifiableList
    public List<Car> getCars(){
        return this.cars;
    }

    public List<Car> getWinners(){
        if (!isEnded()) throw new IllegalStateException("게임 종료 안됨");
        return this.cars.stream()
                .collect(Collectors.groupingBy(Car::getPosition))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Entry::getValue)
                .orElseGet(List::of);
    }

    public void playTurn() {
        if (isEnded()) throw new IllegalStateException("게임이 이미 종료됨");
        cars.forEach(car->{
            if (random.nextInt(10) >= 4)
                car.move();
        });
        attemptedNumber++;
    }

    public boolean isEnded(){
        return this.attemptedNumber == this.numberToAttempt;
    }
}
