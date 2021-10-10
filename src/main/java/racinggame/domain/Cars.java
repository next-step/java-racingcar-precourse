package racinggame.domain;

import racinggame.common.Constant;

import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCars() {
        return carList;
    }

    public int getCarsSize() {
        return this.carList.size();
    }

    public void play(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            carList.get(i).move(numbers.get(i));
        }
    }

    public String winner() {
        calculate();
        StringBuilder result = new StringBuilder();
        result.append(Constant.STR_EMPTY);
        for (Car car : carList) {
            result.append(isFirstRank(car));
        }
        return result.deleteCharAt(result.lastIndexOf(",")).toString();
    }

    private String isFirstRank(Car car) {
        String result = Constant.STR_EMPTY;
        if ( !Constant.STR_EMPTY.equals(car.firstRank()) ) {
            result += car.firstRank() + Constant.STR_COMMA;
        }
        return result;
    }

    private void calculate() {
        for (Car car : carList) {
            car.initial();
            compare(car);
        }
    }

    private void compare(Car compOne) {
        for (Car compTwo : carList) {
            compOne.compare(compTwo);
        }
    }

}
