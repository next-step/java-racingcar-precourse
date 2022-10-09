package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {
    private List<Car> carList;

    public Cars(String[] carNames) {
        validateCarListSize(carNames);
        this.carList = this.mapper(carNames);
    }

    private void validateCarListSize(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException("[ERROR] 자동차 입력 값은 2개 이상이어야 합니다.");
        }
    }

    private List<Car> mapper(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(new Name(carNames[i]), new Position(0)));
        }
        return cars;
    }

    public void race() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(createSingleDigitRandomValue());
        }
    }

    private int createSingleDigitRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinnerList() {
        int maxPosition = getMaxPosition();
        Winners winners = new Winners();
        for (Car car : carList) {
            winners.addCarInMaxPosition(car, maxPosition);
        }
        return winners.getAll();
    }

    private int getMaxPosition() {
        return Collections.max(carList
                , Comparator.comparingInt(Car::getPosition)).getPosition();
    }
}
