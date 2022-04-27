package racingcar.domain.racinggame.service;

import racingcar.domain.InputData;
import racingcar.domain.lap.Lap;
import racingcar.domain.car.*;
import racingcar.global.config.GameConfig;
import racingcar.global.constant.ErrorCode;
import racingcar.global.utils.ConsoleUtils;
import racingcar.global.validate.ValidateCar;
import racingcar.global.validate.ValidateCommon;
import racingcar.global.validate.ValidateLap;
import racingcar.view.RacingGameView;

public class RacingGameService {
    private final Cars cars;
    private Lap lap;

    public RacingGameService() {
        this.cars = Cars.getInstance();
    }

    public void createCar() {
        InputData inputData = new InputData(ConsoleUtils.inputData());
        validateInputData(inputData);
        Cars.createCar(inputData);
    }

    public void inputLap() {
        InputData inputData = new InputData(ConsoleUtils.inputData());
        validateInputLapData(inputData);
        lap = new Lap(inputData);
    }


    public void racingStart() {
        for (int i = 0; i < lap.getLap(); i++) {
            racingCar();
        }
    }

    private void racingCar() {
        RacingGameView racingGameView = new RacingGameView();
        for (int i = 0; i < cars.getCarsSize(); i++) {
            RandomNumber randomNumber = new RandomNumber();
            Car car = cars.getCars(i);
            car.addDriven(randomNumber);
            racingGameView.outputCarDistance(car);
        }
        System.out.println();
    }


    public void racingResult() {
        Driven maxDriven = new Driven();
        for (Car car : cars.getCars()) {
            getMaxDriven(car, maxDriven);
        }
        getWinList(maxDriven);
    }


    private Driven getMaxDriven(Car car, Driven maxDriven) {
        if (car.getDriven() > maxDriven.getDriven()) {
            maxDriven.setDriven(car.getDriven());
        }
        return maxDriven;
    }

    private void getWinList(Driven maxDriven) {
        WinCars winCars = new WinCars();
        for (Car car : cars.getCars()){
            addCar(car, maxDriven, winCars);
        }
        RacingGameView racingGameView = new RacingGameView();
        racingGameView.outputWinCars(winCars);
    }

    private WinCars addCar(Car car, Driven maxDriven, WinCars winCars) {
        if (maxDriven.getDriven() == car.getDriven()){
            winCars.addCar(car.getName());
        }
        return winCars;
    }

    private void validateInputData(InputData inputData) {
        validateIsEmpty(inputData);
        validateCarZeroNameLength(inputData);
        validateCarNameLength(inputData);
        validateDuplicatedCarName(inputData);
    }

    private void validateInputLapData(InputData inputData) {
        validateIsEmpty(inputData);
        validateIsNumber(inputData);
        validateInputDataLapSize(inputData);
    }

    private void validateIsEmpty(InputData inputData) {
        if(ValidateCommon.isEmpty(inputData)) {
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.NOT_INPUT.getMessage());
        }
    }


    private void validateCarZeroNameLength(InputData inputData) {
        if (ValidateCar.isValidCarZeroNameLength(inputData)){
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.INVALID_CAR_ZERO_NAME_LENGTH.getMessage());
        }
    }

    private void validateCarNameLength(InputData inputData) {
        if (ValidateCar.isInvalidCarNameLength(inputData)){
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.INVALID_CAR_LENGTH.getMessage());
        }
    }

    private void validateDuplicatedCarName(InputData inputData) {
        if(ValidateCar.isDuplicatedCarName(inputData)) {
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private void validateIsNumber(InputData inputData) {
        if (!ValidateCommon.isNumber(inputData)) {
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.INVALID_INPUT_DATA.getMessage());
        }
    }

    private void validateInputDataLapSize(InputData inputData) {
        if (!ValidateLap.isValidLapSize(inputData)) {
            throw new IllegalArgumentException(GameConfig.ERROR_PREFIX + ErrorCode.INVALID_LAP_SIZE.getMessage());
        }
    }
}
