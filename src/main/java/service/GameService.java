package service;

import model.Car;
import util.CarFactory;
import util.RacingGameUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GameService {
    private List<Car> cars = new ArrayList<>();

    public int getRound() {
        return round;
    }

    private int round;

    public void setRound(int round) {
        this.round = round;
    }

    public LinkedHashMap<String, Integer> setCars(String carNamesInput) {
        String[] carsString = carNamesInput.split(",");

        // 이후 슈퍼카로 변경시 이 부분을 바꾸면 된다.
        for (String carname : carsString) {
            cars.add(CarFactory.getBasicCar(RacingGameUtil.checkIfCarnameIsValid(carname)));
        }

        return getCarsInfo();
    }

    public LinkedHashMap<String, Integer> getCarsInfo() {
        LinkedHashMap<String, Integer> carHashMap = new LinkedHashMap<>();
        for (Car car : cars) {
            carHashMap.put(car.getCarname(), car.getDistance());
        }
        return carHashMap;
    }

    public LinkedHashMap<String, Integer> palyRouound() {
        for (Car car : cars) {
            car.run();
        }

        return getCarsInfo();
    }

    public LinkedHashMap<String, Integer> 우승자가리기(){
        return RacingGameUtil.judgeTheWinner(getCarsInfo());
    }



}
