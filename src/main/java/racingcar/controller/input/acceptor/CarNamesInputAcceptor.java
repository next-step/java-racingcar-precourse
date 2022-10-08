package racingcar.controller.input.acceptor;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.user.input.CarNamesInput;
import racingcar.controller.user.input.UserInput;

public class CarNamesInputAcceptor implements InputAcceptor {
    @Override
    public UserInput accept() {
        final String carNamesInputString = Console.readLine();
        return new CarNamesInput(carNamesInputString);
    }
}
