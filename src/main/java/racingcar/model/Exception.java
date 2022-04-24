package racingcar.model;

import racingcar.ui.Output;

public class Exception {
    public boolean nameLengthException(String name) {
        try {
            if (!new Name(name).checkLength()) {
                throw new IllegalArgumentException(Output.NAME_LENGTH_EXCEPTION_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean nameDuplicationException(String[] nameList) {
        try {
            if (!new Name(nameList).checkDuplication()) {
                throw new IllegalArgumentException(Output.NAME_DUPLICATE_EXCEPTION_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean prepareAttemptException(String attempt) {
        try {
            if (!attempt.matches("^[1-9]*?")) {
                throw new IllegalArgumentException(Output.ATTEMPT_FORMAT_EXCEPTION_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return false;
        }
        return true;
    }
}
