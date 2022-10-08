package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarName;
import racingcar.domain.Positive;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<CarName> carNames() {
        List<CarName> carNames = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(" + CAR_NAME_DELIMITER + ")를 기준으로 구분).");
        for (final String name : Console.readLine().split(CAR_NAME_DELIMITER)) {
            carNames.add(new CarName(name));
        }
        return carNames;
    }

    public static int numberOfRaces() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new Positive(Console.readLine()).intValue();
    }
}
