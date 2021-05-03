package racingcar.view;

import racingcar.domain.Cars;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class ResultOutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String MOVE_RESULT_MESSAGE = "실행결과";
    private static final String WINNERS_FORMAT = "%s가 최종 우승했습니다.%s";
    private final Scanner scanner;

    public ResultOutputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void responseMoveResult() {
        System.out.printf("%s%s%s", LINE_SEPARATOR, MOVE_RESULT_MESSAGE, LINE_SEPARATOR);
    }

    public void responseMoveResult(Cars cars) {
        cars.forEach(car -> System.out.printf("%s:%s%s", car.getName(), convertPositionToDash(car.getPosition()), LINE_SEPARATOR));
        System.out.println();
    }

    private String convertPositionToDash(int position) {
        return position == 0 ? "" : String.format("%0" + position + "d", 0).replace("0", "-");
    }

    public void responseWinners(Cars cars) {
        AtomicReference<String> names = new AtomicReference<>("");
        cars.forEach(car -> names.set(names.get() + ", " + car.getName()));
        System.out.printf(WINNERS_FORMAT, names.get().substring(2), LINE_SEPARATOR);
    }
}