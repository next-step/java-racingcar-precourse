package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.RacingGameConstants.MOVING_CONDITION;
import static racingcar.RacingGameConstants.RANDOM_LOWER_BOUND;
import static racingcar.RacingGameConstants.RANDOM_UPPER_BOUND;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingGameLogic {

    private static RacingGameLogic instance;

    public static RacingGameLogic getInstance() {
        if (null == instance) {
            instance = new RacingGameLogic();
        }
        return instance;
    }

    private RacingGameLogic() {
    }

    public List<Car> parserCarName(String names) {
        String[] car_names = names.split(",");
        List<Car> ret = new ArrayList<>();
        for (String name : car_names) {
            ret.add(new Car(name));
        }
        return ret;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car c) {
        if (canMove()) {
            c.setMoveCount(c.getMoveCount() + 1);
        }
    }

    private boolean canMove() {
        return pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND) >= MOVING_CONDITION;
    }

    public List<String> selectWinnerName(List<Car> cars) {
        List<String> ret_cars = new ArrayList<>();
        int max_count = getMaxMovingCount(cars);
        for (Car c : cars) {
            if (c.getMoveCount() == max_count) {
                ret_cars.add(c.getName());
            }
        }
        return ret_cars;
    }

    private int getMaxMovingCount(List<Car> cars) {
        int return_value = -1; // moving count must be up to 0, -1 is always min
        for (Car car : cars) {
            return_value = Math.max(return_value, car.getMoveCount());
        }
        return return_value;
    }
}
