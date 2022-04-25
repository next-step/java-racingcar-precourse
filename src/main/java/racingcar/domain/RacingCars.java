package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public static final int VALUE_RANDOM_MIN = 0;
    public static final int VALUE_RANDOM_MAX = 9;

    private final List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public void moveCars() {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(VALUE_RANDOM_MIN, VALUE_RANDOM_MAX));
        }
    }

    public List<String[]> getCurrentStatus() {
        List<String[]> currentStatus = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            currentStatus.add(generateStatus(racingCars.get(i)));
        }
        return currentStatus;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar car : racingCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> getCarNamesByPosition(int position) {
        List<String> result = new ArrayList<>();
        for (RacingCar car : racingCars) {
            addCarNamesAtPosition(result, car, position);
        }
        return result;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private String[] generateStatus(RacingCar racingCar) {
        String[] status = {racingCar.getName(), String.valueOf(racingCar.getPosition())};
        return status;
    }

    private void addCarNamesAtPosition(List<String> carNames, RacingCar car, int position) {
        if (car.getPosition() == position) {
            carNames.add(car.getName());
        }
    }
}
