package racingcar.views;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.cars.Car;
import racingcar.cars.Cars;
import racingcar.firstcollections.Positive;
import racingcar.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class DisplayView {

    private static final String GAME_START_MESSAGE = "경주 할 자동차 이름(이름은쉼표(,) 기준으로구분)";
    private static final String GAME_OVER_MESSAGE = "최종 우승자";
    private static final String RACING_COUNT_MESSAGE = "시도할 회수";
    private static final String CAR_NAME_SEPARATOR = ":";
    private static final String CAR_DISTANCE_SEPARATOR = "-";

    public static void play() {
        start(inputCarNames(), inputRacingCount());
    }

    private static Cars inputCarNames() {
        Cars cars;
        do {
            PrintUtils.println(GAME_START_MESSAGE);
            cars = InputView.inputCarNames();
        } while (cars == null);
        return cars;
    }

    private static Positive inputRacingCount() {
        Positive positive;
        do {
            PrintUtils.println(RACING_COUNT_MESSAGE);
            positive = InputView.inputRacingCount();
        } while (positive == null);
        return positive;
    }

    private static void start(final Cars cars, final Positive positive) {
        while (Positive.MIN_VALUE < positive.get()){
            List<Car> carList = cars.getCars();
            move(carList);
            print(carList);
            positive.sub();
        }
        printWinners(cars);
    }

    private static void move(final List<Car> carList) {
        for (final Car car : carList) {
            car.move(Randoms.pickNumberInRange(Car.MINIMUM_SPEED, Car.MAXIMUM_SPEED));
        }
    }

    private static void print(final List<Car> carList) {
        for (final Car car : carList) {
            printCarName(car);
            printCarDistance(car);
        }
    }

    private static void printCarName(final Car car) {
        PrintUtils.print(String.format("%s %s ", car.getName(), CAR_NAME_SEPARATOR));
    }

    private static void printCarDistance(final Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append(CAR_DISTANCE_SEPARATOR);
        }
        PrintUtils.println(sb.toString());
    }

    private static void printWinners(final Cars cars) {
        PrintUtils.print(String.format("%s%s ", GAME_OVER_MESSAGE, CAR_NAME_SEPARATOR));
        List<String> winnerNames = new ArrayList<>();
        for (final Car car : cars.getWinners()) {
            winnerNames.add(car.getName());
        }
        PrintUtils.println(String.join(",", winnerNames));
    }
}
