package racingcar.domain;

import java.util.*;

public class Cars {

    public static final String SEPARATOR = ",";
    public static final String DELIMITER = ", ";

    private List<Car> carList;
    private MoveStrategy moveStrategy;

    public Cars(String names) {
        this.carList = createCarList(names);
        this.moveStrategy = new CarMoveStrategy();
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
        this.moveStrategy = new CarMoveStrategy();
    }

    public List<Car> createCarList(String names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names.replace(" ", "").split(SEPARATOR)) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public String getWinners() {
        int maxPos = getMaxPosItion();
        String winners = "";
        for (Car car : this.carList) {
            winners = getWinner(car, maxPos, winners);
        }
        if(winners.length() > 0) winners = winners.substring(0, winners.length()-DELIMITER.length());
        return winners;
    }

    private String getWinner(Car car, int maxPos, String winners) {
        if(car.isWinner(maxPos)) winners += car.getName() + DELIMITER;
        return winners;
    }

    private int getMaxPosItion() {
        int maxPos = Integer.MIN_VALUE;
        for (Car car : this.carList) {
            maxPos = Math.max(maxPos, car.getPosition());
        }
        return maxPos;
    }

    public void move() {
        for (Car car : carList) {
            car.move(this.moveStrategy);
        }
    }
}