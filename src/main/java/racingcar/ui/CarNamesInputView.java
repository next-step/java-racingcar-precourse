package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CarNamesInputView {
    private static final String QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_DELIMITER = ",";

    public static CarNamesInput inputCarNames() {
        printQuestion();
        readCarNames();
        final String inputValue = readLine();
        final String[] tokens = inputValue.split(NAME_DELIMITER);

        final List<String> trimmedNames = new ArrayList<>();
        for (String token : tokens) {
            trimmedNames.add(token.trim());
        }

        return new CarNamesInput(trimmedNames);
    }

    private static void readCarNames() {

    }

    private static void printQuestion() {
        System.out.println(QUESTION);
    }

    private static String readLine() {
        return Console.readLine();
    }
}
