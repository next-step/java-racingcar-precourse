package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racing.result.Result;

public class RacingCarConsoleView implements RacingCarView {

    @Override
    public String readLine(String question) {
        System.out.println(question);
        return Console.readLine();
    }

    @Override
    public void printResult(Result result) {
        System.out.println(RESULT_HEADER);
        System.out.println(result);
    }
}
