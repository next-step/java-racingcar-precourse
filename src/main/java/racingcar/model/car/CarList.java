package racingcar.model.car;

import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.SystemOutputView;

public class CarList {

    private final List<Car> carList;

    public CarList(List<Car> cars) {
        validateIfNullOrEmpty(cars);
        this.carList = cars;
    }

    public void startRaceOneTime() {
        for (Car car : carList) {
            car.changeDistance(generatedRandomValue());
            SystemOutputView.currentCarDistance(car.getCurrentStatusToString());
        }
    }

    public List<Car> getHeadCarList() {
        int maxDistanceOfCarList = getMaxDistanceOfCarList();
        List<Car> headCarList = new ArrayList<>();

        for (Car car : carList) {
            addHeadCarList(maxDistanceOfCarList, headCarList, car);
        }

        return headCarList;
    }

    private void addHeadCarList(int maxDistanceOfCarList, List<Car> headCarList, Car car) {
        if (car.getDistanceCount() == maxDistanceOfCarList) {
            headCarList.add(car);
        }
    }

    private int getMaxDistanceOfCarList() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getDistanceCount());
        }

        return maxDistance;
    }

    private void validateIfNullOrEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("선택된 자동차가 없습니다.");
        }
    }

    private CarBehavior generatedRandomValue() {
        int numberInRange = Randoms.pickNumberInRange(RACING_CAR_MOVING_RANGE_VALUE_MIN,
            RACING_CAR_MOVING_RANGE_VALUE_MAX);

        return new CarBehavior(numberInRange);
    }

}
