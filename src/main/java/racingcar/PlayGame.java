package racingcar;

import static racingcar.Constant.INPUT_MSG_CARNAME;
import static racingcar.Constant.INPUT_MSG_TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class PlayGame {
    TryNumber tryNumber;
    Cars cars;

    public void playGame() {
        getInput();
        playTurn(cars);
    }

    public void playTurn(Cars cars) {
        for (int i = 0; i < tryNumber.tryCount; i++) {
            cars.moveCars();
            cars.printCarsStatus();
        }
        cars.printWinnerCars();
    }

    public void getInput() throws IllegalArgumentException {
        getCarInput();
        getTryNumberInput();
    }

    private void getCarInput() {
        boolean carNameCheckBoolean = false;
        while (!carNameCheckBoolean) {
            System.out.println(INPUT_MSG_CARNAME);
            String carNamesString = Console.readLine();
            carNameCheckBoolean = carNameCheck(carNamesString);
        }
    }

    private boolean carNameCheck(String carNamesString) {
        String[] carNames = carNamesString.split(",");
        cars = new Cars();
        boolean carValidateCheck = true;

        for (int i = 0; i < carNames.length && carValidateCheck; i++) {
            String carName = carNames[i];
            carValidateCheck = makeCarValidate(carName, cars);
        }

        return carValidateCheck;
    }

    private boolean makeCarValidate(String carName, Cars cars) {
        try {
            Car car = new Car(carName, 0);
            cars.addCar(car);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
        return true;
    }

    public void getTryNumberInput() {
        boolean tryNumberCheck = false;
        while (!tryNumberCheck) {
            System.out.println(INPUT_MSG_TRY_COUNT);
            String checkNumberString = Console.readLine();

            tryNumberCheck = inputTryNumberValidate(checkNumberString);
        }
    }

    private boolean inputTryNumberValidate(String checkNumberString) {
        try {
            tryNumber = new TryNumber(checkNumberString);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
        return true;
    }
}