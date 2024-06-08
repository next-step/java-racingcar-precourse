package service;

import model.Car;
import util.CarFactory;
import util.RacingGameUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public int getRound() {
        return ROUND;
    }

    private final int ROUND;


    public RacingGame(List<String> vaildCarNames, int ROUND) {
        setCars(vaildCarNames);
        this.ROUND = ROUND;
    }

    private LinkedHashMap<String, Integer> setCars(List<String> vaildCarNames) {
        for (String carname : vaildCarNames) {
            cars.add(CarFactory.getBasicCar(carname));
        }

        return getCarsInfo();
    }

    public LinkedHashMap<String, Integer> palyRouound() {
        for (Car car : cars) {
            car.run();
        }
        return getCarsInfo();
    }

    public LinkedHashMap<String, Integer> calculateWinner(){
        return RacingGameUtil.judgeTheWinner(getCarsInfo());
    }

    public LinkedHashMap<String, Integer> getCarsInfo() {
        LinkedHashMap<String, Integer> carHashMap = new LinkedHashMap<>();
        for (Car car : cars) {
            carHashMap.put(car.getCarname(), car.getDistance());
        }
        return carHashMap;
    }

}
