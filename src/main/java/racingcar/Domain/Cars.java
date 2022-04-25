package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private List<Car> cartList;

    public Cars(CarNames carNames) {
        this.cartList = generationCars(carNames);
    }

    private List<Car> generationCars(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.getCarNameList()) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveCars() {
        for (Car car : cartList) {
            car.move(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
    }

    public List<Car> getWinnerList() {
        List<Car> carList = new ArrayList<>();
        compareWinnerPosition();
        for (Car car : cartList) {
            addCar(carList, car);
        }
        return carList;
    }

    private void addCar(List<Car> carList, Car car) {
        if (car.isWinner()) {
            carList.add(car);
        }
    }

    private void compareWinnerPosition() {
        int winnerPosition = getWinnerPosition();
        for (Car car : cartList) {
            car.comparePosition(winnerPosition);
        }
    }

    private int getWinnerPosition() {
        List<Integer> postionList = new ArrayList<>();
        for (Car car : cartList) {
            postionList.add(car.getPosition());
        }
        return Collections.max(postionList);
    }

    public List<Car> getCarList() {
        return this.cartList;
    }

}
