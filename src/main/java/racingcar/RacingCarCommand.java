package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarCommand {

    private static final int MIN_COMMAND_NUMBER = 0;

    private static final int MAX_COMMAND_NUMBER = 9;

    private static final int MIN_MOVE_COMMAND_NUMBER = 4;

    private static final int MAX_STOP_COMMAND_NUMBER = 3;

    private final int command;

    public RacingCarCommand(int command) {
        validationCommandNumber(command);
        this.command = command;
    }

    public RacingCarCommand() {
        int command = Randoms.pickNumberInRange(MIN_COMMAND_NUMBER, MAX_COMMAND_NUMBER);
        validationCommandNumber(command);
        this.command = command;
    }

    private void validationCommandNumber(int command) {
        if (!validationCommandNumberRange(command)) {
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NUMBER_ERROR);
        }
    }

    private boolean validationCommandNumberRange(int command) {
        return command >= MIN_COMMAND_NUMBER && command <= MAX_COMMAND_NUMBER;
    }

    public boolean isMoveCommand() {
        return command >= MIN_MOVE_COMMAND_NUMBER;
    }

    public boolean isStopCommand() {
        return command <= MAX_STOP_COMMAND_NUMBER;
    }

}
