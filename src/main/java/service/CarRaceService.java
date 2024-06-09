package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import model.Car;

public class CarRaceService {
    private List<Car> cars;
    private Random random;

    public CarRaceService() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }

    // 차량 생성 시 차량 이름 검증
    public void createCars(String input) {
        String[] carNames = input.split(",");
        Set<String> nameSet = new HashSet<>();
        List<Car> newCars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if(name.length() > 5 || name.length() < 1)
            {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
            }
            nameSet.add(name);
            newCars.add(new Car(name));
        }
        cars = newCars;

    }

    public void race(int tryCount) { // 시도 횟수만큼 차량 레이스 진행
        if(tryCount < 1)
            throw new IllegalArgumentException(("[ERROR] 시도 횟수는 1 이상의 정수로 입력 가능합니다."));

        for (int i = 0; i < tryCount; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            car.move(random.nextInt(10)); // 차량 랜덤값 4보다 크면 이동 아니면 그대로 둔다.
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() { // 우승 차량 찾아서 반환
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
