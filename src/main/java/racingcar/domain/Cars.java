package racingcar.domain;

import racingcar.constant.CarConstant;
import racingcar.constant.Message;
import racingcar.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cars {
    private final List<Car> carItems;

    public Cars(List<Car> carItems) {
        this.carItems = carItems;
    }

    public List<Car> getCarItems() {
        return carItems;
    }

    public static Cars createCars(String names) {
        validateCarNames(names);
        String[] splitNames = getSplitNames(names);
        return new Cars(mapCar(splitNames));
    }

    public static String getWinnerNames(Cars winnerCars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winnerCars.getCarItems()) {
            winnerNames.add(
                    Optional.ofNullable(car.getCarName())
                            .orElseThrow(() -> new IllegalArgumentException(Message.INPUT_RACING_CAR_NAMES))
                            .getName()
            );
        }

        return String.join(CarConstant.WINNER_NAME_DELIMITER, winnerNames);
    }

    public Cars getWinnerCars() {
        List<Car> winnerCar = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : carItems) {
            addWinnerCar(winnerCar, car, maxDistance);
        }
        return new Cars(winnerCar);
    }

    private static List<Car> mapCar(String[] splitNames) {
        List<Car> carItems = new ArrayList<>();
        for (String name : splitNames) {
            carItems.add(Car.createCar(name));
        }
        return carItems;
    }

    private static String[] getSplitNames(String names) {
        return names.split(CarConstant.COMMA);
    }

    private static void validateCarNames(String names) {
        if (CommonUtils.isNullOrEmptyString(names)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NULL_OR_EMPTY);
        }
    }

    private int getMaxDistance() {
        int max = 0;
        for (Car car : carItems) {
            max = CommonUtils.isGreaterThanNumber(car.getDistance(), max) ? car.getDistance() : max;
        }
        return max;
    }

    private void addWinnerCar(List<Car> winnerCars, Car car, int maxDistance) {
        if (isMaxDistanceCar(car, maxDistance)) {
            winnerCars.add(car);
        }
    }

    private boolean isMaxDistanceCar(Car car, int maxDistance) {
        return car.getDistance() == maxDistance;
    }

    @Override
    public Object clone() {
        List<Car> cloneCarItems = new ArrayList<>();
        for (Car car : carItems) {
            Car cloneCar = new Car(car.getCarName(), car.getDistance());
            cloneCarItems.add(cloneCar);
        }
        return new Cars(cloneCarItems);
    }
}
