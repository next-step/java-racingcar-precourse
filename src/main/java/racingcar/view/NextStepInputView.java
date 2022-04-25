package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class NextStepInputView implements InputView {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
