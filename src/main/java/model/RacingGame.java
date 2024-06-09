package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    /**
     * 자동차 이름 리스트를 받아 생성하는 생성자
     * @param carNames 자동차 이름 리스트
     */
    public RacingGame(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    /**
     * 주어진 횟수만큼 자동차 경주를 진행하는 메서드
     * @param trials 시도할 횟수
     */
    public void race(int trials) {
        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    /**
     * 현재 자동차 리스트를 반환하는 메서드
     * @return 현재 자동차 리스트
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 현재 가장 멀리 있는 자동차의 위치를 반환하는 메서드
     * @return 현재 가장 멀리 있는 자동차의 위치
     */
    public List<String> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
