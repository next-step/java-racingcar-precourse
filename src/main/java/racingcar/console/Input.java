package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racing.Message;
import racingcar.domain.racing.Turn;
import racingcar.domain.car.CarName;

public class Input {
    private CarName carName;
    private Turn turn;

    public String getNames() {
        Output.printMessage(Message.GET_CARS_NAME_MESSAGE.getMessage());
        try {
            carName = new CarName(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorAndRetryGetNames();
        }
        return carName.getName();
    }

    private void printErrorAndRetryGetNames() {
        Output.printMessage(Message.ERROR_CAR_NAME_OVERSIZE_MESSAGE.getMessage());
        getNames();
    }

    public int getTurn() {
        Output.printMessage(Message.GET_TURN_MESSAGE.getMessage());
        try {
            turn = new Turn(Integer.valueOf(Console.readLine()));
        } catch (IllegalArgumentException e) {
            printErrorAndRetryGetTurn();
        }
        return turn.getTurnValue();
    }

    private void printErrorAndRetryGetTurn() {
        Output.printMessage(Message.ERROR_TURN_INPUT_MESSAGE.getMessage());
        getTurn();
    }
}
