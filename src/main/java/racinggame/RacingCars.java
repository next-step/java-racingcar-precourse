package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private static final String SEPARATOR = ",";
    private static final int RACE_START_NUMBER = 0;
    private static final int RACE_END_NUMBER = 9;
    private static final String ADVANCE_STR = "-";

    private List<Car> racingCars;
    private List<Car> winningCars = new ArrayList<>();

    public RacingCars(String racingCarNames) {
        String[] racingCars = racingCarNames.split(SEPARATOR);
        List<Car> carList = new ArrayList<>();
        for (String racingCarName : racingCars) {
            Car car = new Car(racingCarName);
            carList.add(car);
        }
        this.racingCars = carList;
    }

    public List<Car> getRacingCarList() {
        return this.racingCars;
    }

    public void racing() {
        for (Car car : racingCars) {
            car.racing(Randoms.pickNumberInRange(RACE_START_NUMBER, RACE_END_NUMBER));
        }
    }

    public String getWinningCarName() {
        int maxAdvance = 0;
        for (Car car : racingCars) {
            maxAdvance = getMaxAdvance(maxAdvance, car.getAdvance());
        }
        for (Car car : racingCars) {
            addWinningCar(maxAdvance, car);
        }
        return getCarNameByWinningCar();
    }

    public void printProgress() {
        for (Car car : racingCars) {
            System.out.println(car.getName() + ": "
                    + String.join("", Collections.nCopies(car.getAdvance(), ADVANCE_STR)));
        }
    }

    private void addWinningCar(int maxAdvance, Car car) {
        if (maxAdvance == car.getAdvance()) {
            winningCars.add(car);
        }
    }

    private String getCarNameByWinningCar() {
        String winningCarName = "";
        for (Car car : winningCars) {
            winningCarName += car.getName() + SEPARATOR;
        }
        return winningCarName.substring(0, winningCarName.length() - 1);
    }

    private int getMaxAdvance(int prevValue, int nextValue) {
        return prevValue > nextValue ? prevValue : nextValue;
    }
}
