package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.request.RoundNumberRequestInfo;

public class RoundNumberInputView {

    public static RoundNumberRequestInfo inputValue() {
        System.out.println("시도할회수는몇회인가요?");
        return create(Console.readLine());
    }

    private static RoundNumberRequestInfo create(String inputValue) {
        return new RoundNumberRequestInfo(inputValue);
    }
}
