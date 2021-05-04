import dto.RaceResult;
import model.Car;
import model.RacingCars;
import model.Winners;
import util.RandomUtil;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void start() {
        InputView inputView = new InputView();
        RacingCars racingCars = inputRacingCars(inputView);
        int tryCount = inputTryCount(inputView);
        inputView.exit();

        play(racingCars, tryCount);
        end(racingCars);
    }

    private RacingCars inputRacingCars(InputView inputView) {
        String input = inputView.inputRacingCarNames();
        String[] racingCarNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String racingCarName : racingCarNames) {
            cars.add(new Car(racingCarName));
        }

        return new RacingCars(cars);
    }

    private int inputTryCount(InputView inputView) {
        String tryCount = inputView.inputTryCount();
        return Integer.parseInt(tryCount);
    }

    private void play(RacingCars racingCars, int tryCount) {
        OutputView.printResultIntro();

        while (tryCount-- > 0) {
            List<Integer> randomNumbers = RandomUtil.generateRandomNumbers(racingCars.getSize());
            RaceResult result = racingCars.race(randomNumbers);
            OutputView.printResult(result);
        }
    }

    private void end(RacingCars racingCars) {
        Winners winners = racingCars.getWinners();
        OutputView.printWinners(winners);
    }
}
