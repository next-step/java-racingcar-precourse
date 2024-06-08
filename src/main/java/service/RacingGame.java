package service;

import model.Car;
import util.CarFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public int getRound() {
        return ROUND;
    }

    private final int ROUND;


    public RacingGame(List<Car> cars, int ROUND) {
        this.cars = cars;
        this.ROUND = ROUND;
    }



    public LinkedHashMap<String, Integer> palyRouound() {
        for (Car car : cars) {
            car.run();
        }
        return getCarsInfo();
    }

    public LinkedHashMap<String, Integer> calculateWinner(){
        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();
            LinkedHashMap<String, Integer> originalMap = getCarsInfo();
            // 최대값 찾기
            int max = originalMap.values().stream().max(Integer::compare).orElse(-1);

            // 최대값을 가진 항목들을 새로운 LinkedHashMap에 추가
            for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
                if (entry.getValue().equals(max)) {
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }

            return resultMap;
        }


    public LinkedHashMap<String, Integer> getCarsInfo() {
        LinkedHashMap<String, Integer> carHashMap = new LinkedHashMap<>();
        for (Car car : cars) {
            carHashMap.put(car.getCarname(), car.getDistance());
        }
        return carHashMap;
    }

}
