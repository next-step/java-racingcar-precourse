package racinggame;

import racinggame.message.MessageController;
import racinggame.model.Car;

import java.util.ArrayList;
import java.util.List;

import static nextstep.utils.Console.readLine;

public class Game {

    private final int MIN_NUM = 0;
    private final int MAX_NUM = 9;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int MOVING_REFERENCE_VALUE = 4;

    public void play() {
        MessageController.getInstance().start();

        List<Car> cars = inputCarInfos();
    }

    private List<Car> inputCarInfos() {
        String[] carNameList = checkCarName(input());
        return createCars(carNameList);
    }

    private String input() {
        return readLine();
    }

    private String[] separateCarName(String carNames) {
        return carNames.split(",");
    }

    public boolean isValidatedCarName(String[] carNames) {
        int carNamesLen = carNames.length;
        int index = 0;

        while (index < carNamesLen && checkCarNameLength(carNames[index])) {
            index++;
        }

        return index == carNamesLen;
    }

    private boolean checkCarNameLength(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private String[] checkCarName(String carNames) {
        String[] carNameList = separateCarName(carNames);

        boolean isValidatedCarName = isValidatedCarName(carNameList);

        if (!isValidatedCarName) {
            MessageController.getInstance().error();
            play();
        }
        return carNameList;
    }


    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
        return cars;
    }

}
