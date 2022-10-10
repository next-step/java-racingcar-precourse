package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.util.Arrays.*;

import java.util.List;

public class InputView {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_MESSAGE = "시도할 회수";

    private InputView() {
    }

    public static List<String> readCarsName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] names = readLine().split(",");
        return asList(names);
    }

    public static String readCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return readLine();
    }
}
