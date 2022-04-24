package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.ui.CarStatus;
import racingcar.ui.Output;

public class Racing {
    public Cars start(Cars cars) {
        for (Car car : cars.getCars()) {
            int number = Randoms.pickNumberInRange(0, 9);
            car.setStatus(moveOrStop(number));
            move(car);
            Output.printResultOutputMessage(car.getName(), car.getLocation());
        }
        return cars;
    }

    public CarStatus moveOrStop(int number) {
        if (number >= 4) {
            return CarStatus.MOVE;
        }
        return CarStatus.STOP;
    }

    public void move(Car car) {
        if (car.getStatus() == CarStatus.MOVE) {
            car.addLocation();
        }
    }
}