package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Constants.*;

public class GameController {

    private final UserInterface userInterface;

    public GameController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Cars cars = new Cars(getCarNames());
        DriveNumber driveNumber = getDriveNumber();

        for (int i = 0; i < driveNumber.getValue(); i++) {
            driveAll(cars);
        }

        userInterface.printWinners(cars.getWinners());
    }

    private void driveAll(Cars cars) {
        cars.driveAll(createRandomNumbers(cars.getSize()));
        printCars(cars);
        System.out.println();
    }

    private CarNames getCarNames() {
        CarNames names = createCarNames();
        while (names == null) {
            names = createCarNames();
        }
        return names;
    }

    private CarNames createCarNames() {
        try {
            return new CarNames(readNames());
        } catch (IllegalArgumentException e) {
            userInterface.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private String[] readNames() {
        userInterface.printCarNamesPrompt();
        return readLine().split(NAME_SEPARATOR);
    }

    private DriveNumber getDriveNumber() {
        DriveNumber driveNumber = createDriveNumber();
        while (driveNumber == null) {
            driveNumber = createDriveNumber();
        }
        return driveNumber;
    }

    private DriveNumber createDriveNumber() {
        try {
            return new DriveNumber(readDriveNumber());
        } catch (IllegalArgumentException e) {
            userInterface.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private String readDriveNumber() {
        userInterface.printDriveNumberPrompt();
        return readLine();
    }

    public List<Integer> createRandomNumbers(int carListSize) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int j = 0; j < carListSize; j++) {
            randomNumbers.add(pickNumberInRange(RANDOM_MIN, RANDOM_MAX));
        }

        return randomNumbers;
    }

    private void printCars(Cars cars) {
        for (Car car : cars.getList()) {
            userInterface.printCar(car.getName(), car.getDistance());
        }
    }
}
