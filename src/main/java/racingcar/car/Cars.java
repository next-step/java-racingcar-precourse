package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.PlayResult;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(String strCarNames) {
        this.cars = convertCars(strCarNames);
    }

    private List<Car> convertCars(String strCarNames) {
        return Arrays.asList(strCarNames.split(SEPARATOR)).stream()
                .map(Car::new)
                .collect(toList());
    }

    public PlayResult play(PlayResult result) {
        for(Car car : cars) {
            int carMove = Randoms.pickNumberInRange(0, 9);
            CarStatus carStatus = car.play(carMove);
            result.report(car, carStatus);
        }
        return result;
    }
}
