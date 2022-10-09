package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.request.CarNameRequestInfo;

public class CarNameInputView {

    private final static String DELIMITER = ",";

    public static CarNameRequestInfo inputValue() {
        System.out.println("경주할자동차이름(이름은쉼표(,)기준으로구분)");
        return create(Console.readLine());
    }

    private static CarNameRequestInfo create(String inputValue) {
        return new CarNameRequestInfo(inputValue.split(DELIMITER));
    }
}
