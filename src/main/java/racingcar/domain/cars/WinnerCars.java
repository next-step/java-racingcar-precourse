package racingcar.domain.cars;

import racingcar.domain.car.Car;

import java.util.List;

public class WinnerCars {
    private final List<Car> carList;

    public WinnerCars(List<Car> carList) {
        this.carList = carList;
    }

    public int numberOfWinner() {
        return carList.size();
    }

    public Car getWinnerCar(int idx) {
        return carList.get(idx);
    }

    public String toWinnerString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName())
                    .append(", ");
        }
        removeLastComma(sb);
        return sb.toString();
    }

    private void removeLastComma(StringBuilder sb) {
        if (carList.size() > 0) {
            sb.deleteCharAt(sb.length() - 1)
                    .deleteCharAt(sb.length() - 1);
        }
    }
}
