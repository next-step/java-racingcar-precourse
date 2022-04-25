package racingcar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Application {

    private static final String SPLIT_REGEX = ",";
    private static final String WINNER_JOIN_REGEX = ", ";
    private static final String CAR_STEP_MARK = "-";
    private static final String CAR_INFORMATION_SUFFIX = " : ";

    public Car[] getInputCarList() {
        String inputData = InputView.getUserData();
        String[] carNameList = inputData.split(SPLIT_REGEX);
        Car[] carList = new Car[carNameList.length];

        for (int i = 0; i < carNameList.length; i++) {
            Validator.validateCarName(carNameList[i]);
            carList[i] = new Car(carNameList[i]);
        }
        return carList;
    }

    public Car[] getCarList() {
        Car[] carList;
        while (true) {
            OutputView.println(OutputView.INTRO_INPUT_CAR);
            try {
                carList = getInputCarList();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return carList;
    }

    public int getInputTryCount() {
        String InputData = InputView.getUserData();
        Validator.validateTryCount(InputData);
        return Integer.parseInt(InputData);
    }

    public int getTryCount() {
        int tryCount = -1;
        while (true) {
            OutputView.println(OutputView.INTRO_INPUT_TRY_COUNT);
            try {
                tryCount = getInputTryCount();
                return tryCount;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void moveTotalCar(Car[] carList) {
        for (Car car : carList) {
            car.movement();
        }
    }

    public void printTotalCar(Car[] carList) {
        for (Car car : carList) {
            printCarData(car);
        }
    }

    public int getMaxPosition(Car[] carList) {
        return Arrays.stream(carList)
            .flatMapToInt((car) -> IntStream.of(car.getPosition()))
            .max()
            .getAsInt();
    }

    public String[] getWinnerList(Car[] carList) {
        int maxValue = getMaxPosition(carList);

        return Arrays.stream(carList)
            .filter((car) -> car.getPosition() == maxValue)
            .map(Car::getName)
            .toArray(String[]::new);
    }

    public void printWinner(String[] winnerList) {
        OutputView.print(OutputView.INTRO_WINNER);
        OutputView.println(String.join(WINNER_JOIN_REGEX, winnerList));
        OutputView.printBlank();
    }

    public void printCarData(Car car) {
        OutputView.print(car.getName() + CAR_INFORMATION_SUFFIX);
        for (int i = 0; i < car.getPosition(); i++) {
            OutputView.print(CAR_STEP_MARK);
        }
        OutputView.printBlank();
    }

    public void run() {
        Car[] carList = getCarList();
        int tryCount = getTryCount();
        System.out.println();

        for (int i = 0; i < tryCount; i++) {
            moveTotalCar(carList);
            printTotalCar(carList);
            System.out.println();
        }

        String[] winnerList = getWinnerList(carList);
        printWinner(winnerList);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}