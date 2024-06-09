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



}
