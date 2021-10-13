package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = inputCarNames();
        int racingTime = inputRacingTime();
        Cars cars = new Cars(makeRacingCars(carNames));
        MoveNums moveNums = new MoveNums(cars);

        CarRacing carRacing = new CarRacing(cars, moveNums, racingTime);
        carRacing.start();
        if(carRacing.isFinish()) {
            OutputView.racingWinner(carRacing.winner());
        }
    }

    private static List<Car> makeRacingCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int inputRacingTime() {
        String racingTime = InputView.readRacingTime();
        while (!ValidationUtils.isNum(racingTime)) {
            racingTime = InputView.readRacingTime();
        }
        return Integer.parseInt(racingTime);
    }

    private static String[] inputCarNames() {
        boolean incorrectCarName = true;
        String[] carNames = null;
        while (incorrectCarName) {
            carNames = SplitUtils.split(InputView.readCarNames());
            incorrectCarName = isIncorrectCarName(carNames);
        }
        return carNames;
    }

    private static boolean isIncorrectCarName(String[] carNames) {
        for(String carName : carNames) {
            if(!ValidationUtils.isCarNameLessThan5words(carName)) return true;
        }
        return false;
    }
}
