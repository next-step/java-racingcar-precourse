package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.assertj.core.util.Lists;

public final class ScannerUtil {

    public static final String INPUT_CARS_NAME_TEXT = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRYOUT_COUNT_TEXT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_CHANGE_CAR_NAME_TEXT = "대신 새로운 자동차 이름을 입력하세요.";

    public static List<String> inputCarsName() {
        String inputString = "";
        System.out.println(INPUT_CARS_NAME_TEXT);
        inputString = Console.readLine();

        List<String> names = Lists.newArrayList(inputString.split(","));

        return names;
    }

    public static String inputTryoutCount() {
        String inputString = "";
        System.out.println(INPUT_TRYOUT_COUNT_TEXT);
        inputString = Console.readLine();
        return inputString;
    }

    public static String inputChangeCarName(String currentName) {
        String inputString = "";
        System.out.println(currentName + " " + INPUT_CHANGE_CAR_NAME_TEXT);
        inputString = Console.readLine();
        return inputString;
    }

}
