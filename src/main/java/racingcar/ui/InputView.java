package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNames;
import racingcar.dto.TryTime;

public class InputView {
    private static final String SPLIT_REGEX = ",";

    public static CarNames getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + SPLIT_REGEX + ") 기준으로 구분)");

        while (true) {
            CarNames carNames = readCarNames();

            if (carNames != null) {
                return carNames;
            }
        }
    }

    private static CarNames readCarNames() {
        try {
            return new CarNames(Console.readLine().split(SPLIT_REGEX));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static TryTime getTryTime() {
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            TryTime tryTime = readTryTime();

            if (tryTime != null) {
                return tryTime;
            }
        }
    }

    private static TryTime readTryTime() {
        try {
            return new TryTime(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
