package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class GameView {
    private final String CAR_NAMES_DELIMITER = ",";
    private final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String GAUGE_CHARACTER = "-";
    private final String INPUT_CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_PLAY_ROUND_COUNT = "시도할 회수";
    private final String WINNER_MESSAGE_PREFIX = "최종 우승자는: ";

    public RacingCars inputRacingCars() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        try {
            String input = Console.readLine();
            validEmpty(input);
            List<Car> cars = parseCarName(input);
            return new RacingCars(cars);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_MESSAGE_PREFIX + iae.getMessage());
            return inputRacingCars();
        }
    }

    private void validEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    private List<Car> parseCarName(String inputCarName) {
        List<Car> cars = new ArrayList<>();
        for (String carName: inputCarName.split(CAR_NAMES_DELIMITER)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int inputRoundCount() {
        System.out.println(INPUT_PLAY_ROUND_COUNT);
        try {
            String input = Console.readLine();
            validRoundCountInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_MESSAGE_PREFIX + iae.getMessage());
            return inputRoundCount();
        }
    }

    private void validRoundCountInput(String input) {
        validEmpty(input);
        validNumber(input);
        validLessZero(input);
    }

    private void validNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다");
        }
    }

    private void validLessZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다");
        }
    }

    public void printCarsPosition(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(String.format("%s : %s", car.getName(), numberToGaugeString(car.getPosition())));
        }
        System.out.println();
    }

    private String numberToGaugeString(int gaugeCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gaugeCount; i++) {
            sb.append(GAUGE_CHARACTER);
        }
        return sb.toString();
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(WINNER_MESSAGE_PREFIX + String.join(", ", winnerNames));
    }
}
