package racingcar.model.game;

import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.UserInputController;
import racingcar.model.car.Car;
import racingcar.model.car.CarList;
import racingcar.model.car.CarName;
import racingcar.model.user.RacingRepeatCount;
import racingcar.model.user.UserInputCarNames;
import racingcar.view.SystemOutputErrorView;
import racingcar.view.SystemOutputView;

public class GameMachine {

    private CarList carList;
    private RacingRepeatCount racingRepeatCount;

    public GameMachine() {
        validateConfig();
    }

    private void validateConfig() {
        if (RACING_CAR_MOVING_RANGE_VALUE_MIN >= RACING_CAR_MOVING_RANGE_VALUE_MAX) {
            throw new IllegalStateException("랜덤값 추출 범위를 확인하세요.");
        }

        if (RACING_CAR_MOVING_RANGE_VALUE_MIN > RACING_CAR_MOVING_STANDARD_VALUE
            || RACING_CAR_MOVING_RANGE_VALUE_MAX < RACING_CAR_MOVING_STANDARD_VALUE) {
            throw new IllegalStateException("자동차의 주행을 판단할 기준 설정값을 확인하세요.");
        }
    }

    public void start() {
        this.init();
        this.startRacing();
    }

    private void init() {
        boolean repeatFlag;

        do {
            repeatFlag = setCarList();
        } while (!repeatFlag);

        do {
            repeatFlag = setRacingRepeatCount();
        } while (!repeatFlag);
    }

    private void startRacing() {
        SystemOutputView.startRacing();
        for (int i = 0; i < racingRepeatCount.getRepeatCount(); i++) {
            carList.startRaceOneTime();
            SystemOutputView.blank();
        }

        SystemOutputView.finishRacing(carList.getHeadCarList());
    }

    private boolean setRacingRepeatCount() {
        SystemOutputView.getRacingRepeatCoount();
        try {
            this.racingRepeatCount = UserInputController.getRacingRepeatCount();
        } catch (IllegalArgumentException exception) {
            SystemOutputErrorView.printError(exception.getMessage());
            return false;
        }

        return true;
    }

    private boolean setCarList() {
        SystemOutputView.getCarsName();
        try {
            UserInputCarNames userInputCarNames = UserInputController.getCarsName();
            this.carList = generateCarList(userInputCarNames);
        } catch (IllegalArgumentException exception) {
            SystemOutputErrorView.printError(exception.getMessage());
            return false;
        }

        return true;
    }

    private CarList generateCarList(UserInputCarNames userInputCarNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : userInputCarNames.getCarNameList()) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return new CarList(cars);
    }

}
