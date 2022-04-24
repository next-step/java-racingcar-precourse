package racingcar.domain.car;

import racingcar.Constant;

import java.util.Scanner;
import java.util.stream.Stream;

public class RaceCar {
    private static final String SEPARATOR = ",";

    public String[] generateRaceCars(Scanner scanner) {
        String input = scanner.nextLine();

        return Stream.of(input.split(Constant.SEPARATOR))
                .map(s -> s.replaceAll(Constant.BLANK, Constant.EMPTY_NAME))
                .toArray(String[]::new);
    }

    public String getRaceCount(Scanner scanner) {
        return scanner.nextLine();
    }
}
