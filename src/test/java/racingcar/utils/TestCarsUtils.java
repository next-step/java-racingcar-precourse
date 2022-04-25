package racingcar.utils;

import static java.lang.String.join;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.car.Cars;
import racingcar.game.InputCarNames;
import racingcar.game.InputRoundCount;
import racingcar.racing.RacingCarResult;
import racingcar.racing.Round;
import racingcar.racing.RoundResult;
import racingcar.racing.RoundResults;
import racingcar.racing.Rounds;
import racingcar.racing.WinnerCounts;

public class TestCarsUtils {

    public static final String DELIMITER = ", ";

    public static List<Car> testCarList() {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < Randoms.pickNumberInRange(1, 10); i++) {
            carList.add(Car.of(randomCarName()));
        }

        return carList;
    }

    public static InputCarNames testInputCarNames() {
        List<String> carStringList = new ArrayList<>();
        for (int i = 0; i < Randoms.pickNumberInRange(1, 10); i++) {
            carStringList.add(randomCarName().getName());
        }

        return InputCarNames.valueOf(join(DELIMITER, carStringList));
    }

    public static Cars testCars() {
        return Cars.of(testCarList());
    }

    public static Car testCar() {
        return Car.of(randomCarName());
    }

    private static CarName randomCarName() {
        return CarName.of("car_" + Randoms.pickNumberInRange(1, 9));
    }

    public static WinnerCounts testWinnerCounts() {
        final WinnerCounts winnerCounts = WinnerCounts.init();
        winnerCounts.countingCars(testCars());
        return winnerCounts;
    }

    public static RoundResult testRandomRoundResult() {
        return RoundResult.report(testCar(),
                Randoms.pickNumberInRange(0, 1) == 0 ? RacingCarResult.GO : RacingCarResult.STOP);
    }

    public static RoundResult testGoRoundResult() {
        return RoundResult.report(testCar(), RacingCarResult.GO);
    }

    public static InputRoundCount testInputRoundCount() {
        return InputRoundCount.valueOf(String.valueOf(Randoms.pickNumberInRange(1, 10)));
    }

    public static Round testRound() {
        return Round.of(testCars());
    }

    public static RoundResults testGoRoundResults(final Car car) {
        final RoundResults roundResults = RoundResults.init();
        roundResults.result(RoundResult.report(car, RacingCarResult.GO));
        return roundResults;
    }

    public static Rounds testRounds() {
        return Rounds.countOf(testInputRoundCount(), testCars());
    }
}
