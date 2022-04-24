package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int INIT_MAX = 0;

    private int numberOfExecutions;
    private int maxCnt;
    private CarList carList;
    private CarList winnerList;

    public Game(String numberOfExecutions) {
        checkInputParameter(numberOfExecutions);
        this.numberOfExecutions = Integer.valueOf(numberOfExecutions);
        this.maxCnt = INIT_MAX;
    }

    public Game(String numberOfExecutions, List<Car> carList) {
        checkInputParameter(numberOfExecutions);
        this.numberOfExecutions = Integer.valueOf(numberOfExecutions);
        this.carList = new CarList(carList);
        this.maxCnt = INIT_MAX;
    }

    private void checkInputParameter(String str) {
        boolean isNotNumeric = !str.chars().allMatch(Character::isDigit);
        if (isNotNumeric) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfExecutions() {
        return numberOfExecutions;
    }

    public void setCarList(List<Car> carList) {
        this.carList = new CarList(carList);
    }

    public CarList getCarList() {
        return carList;
    }

    public void start() {
        for (int i = 0; i < numberOfExecutions; i++) {
            eachCarExcecute(this.carList);
            System.out.println();
        }
        List<Car> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.getCarList().size(); i++) {
            makeResult(carList.getCarByIndex(i), winnerList);
        }
        setWinnerList(winnerList);
        pritOutGameResult();
    }

    private void pritOutGameResult() {
        System.out.print("최종 우승자: ");
        System.out.print(getWinnerList().getCarByIndex(0).getCarName());
        for (int i = 1; i < getWinnerList().getCarList().size(); i++) {
            System.out.print(", ");
            System.out.print(getWinnerList().getCarByIndex(i).getCarName());
        }
        System.out.println();
    }

    private void makeResult(Car car, List<Car> winnerList) {
        if (car.getMoveCnt() > maxCnt) {
            maxCnt = car.getMoveCnt();
            winnerList.clear();
            winnerList.add(car);
            return;
        }
        if (car.getMoveCnt() == maxCnt) {
            winnerList.add(car);
            return;
        }
    }

    private void eachCarExcecute(CarList carList) {
        for (int i = 0; i < carList.getCarList().size(); i++) {
            carList.getCarByIndex(i).move();
            printOutGameProcess(carList.getCarByIndex(i));
        }
    }

    private void printOutGameProcess(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getMoveCnt(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void setWinnerList(List<Car> winnerList) {
        this.winnerList = new CarList(winnerList);
    }

    public CarList getWinnerList() {
        return this.winnerList;
    }
}
