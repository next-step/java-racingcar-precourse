package racingcar.model.collection;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import racingcar.constant.ErrorMessage;
import racingcar.model.Car;
import racingcar.utils.StringUtils;

public class CarGroups {

    private final List<Car> cars;


    public CarGroups(String carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        validateCarCreation();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void showLocations() {
        validateCarCreation();
        for (Car car : cars) {
            int distance = car.getDrivingDistance().getDistance();
            System.out.printf("%s : %s%n", car.getName(), StringUtils.repeatString("-", distance));
        }
        System.out.printf(System.lineSeparator());
    }

    public String getWinners() {
        validateCarCreation();
        cars.sort(getComparatorDistanceDesc());
        int maxDrivingDistance = cars.get(0).getDrivingDistance().getDistance();
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            addWinner(car, sj, maxDrivingDistance);
        }
        return sj.toString();
    }

    private void addWinner(Car car, StringJoiner sj, int maxDrivingDistance) {
        if (car.getDrivingDistance().getDistance() == maxDrivingDistance) {
            sj.add(car.getName());
        }
    }

    private void validateCarCreation() {
        if (cars.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.NOT_CREATION_CAR_MESSAGE);
        }
    }

    private Comparator<Car> getComparatorDistanceDesc() {
        return Comparator.comparing(car -> car.getDrivingDistance().getDistance(), Collections.reverseOrder());
    }

}
