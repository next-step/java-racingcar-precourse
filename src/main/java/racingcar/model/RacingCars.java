package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.ErrorMessage;
import racingcar.enums.MoveStatus;
import racingcar.utils.ValidationUtils;
import racingcar.view.GameView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.*;

public class RacingCars {

    private static final String COLON = " : ";

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public int enterCars() {
        return cars.size();
    }

    public Map<String, Integer> getMovableNumberMap() {
        final Map<String, Integer> movableNumberMap = new HashMap<>();

        for (Car car : cars) {
            final String carName = car.carName();
            int number = Randoms.pickNumberInRange(0, 9);
            movableNumberMap.putIfAbsent(carName, number);
        }

        return movableNumberMap;
    }

    public void moveCar(Map<String, MoveStatus> moveStatusMap) {
        ValidationUtils.validObjectThrowIfNull(moveStatusMap, ErrorMessage.MOVE_STATUS_MAP_IS_REQUIRED);

        for (Car car : cars) {
            final String carName = car.carName();
            final MoveStatus moveStatus = moveStatusMap.get(carName);
            car.actByMoveStatus(moveStatus);
        }
    }

    public String getFinalChampionshipCarNames() {
        final FinalChampionshipCar finalChampionshipCar = getFinalChampionshipCar();
        return finalChampionshipCar.getFinalChampionshipCarNames();
    }

    private FinalChampionshipCar getFinalChampionshipCar() {
        final AtomicInteger topDistance = new AtomicInteger();
        final Map<String, Integer> distanceByName = new LinkedHashMap<>();

        for (Car car : cars) {
            final int distance = car.getDistance();
            topDistance.set(max(topDistance.get(), distance));
            distanceByName.putIfAbsent(car.carName(), distance);
        }

        return new FinalChampionshipCar(topDistance, distanceByName);
    }

    public void outputResult() {
        for (Car car : cars) {
            final String carName = car.carName();
            final String distanceDash = car.getDistanceDash();
            GameView.printMessage(carName + COLON + distanceDash);
        }
    }

}
