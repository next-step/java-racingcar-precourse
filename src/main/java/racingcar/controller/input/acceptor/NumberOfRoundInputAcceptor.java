package racingcar.controller.input.acceptor;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.user.input.NumberOfRoundInput;
import racingcar.controller.user.input.UserInput;

public class NumberOfRoundInputAcceptor implements InputAcceptor {
    @Override
    public UserInput accept() {
        final String numberOfRoundInputString = Console.readLine();
        return new NumberOfRoundInput(numberOfRoundInputString);
    }
}
