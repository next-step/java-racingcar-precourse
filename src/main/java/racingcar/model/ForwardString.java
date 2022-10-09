package racingcar.model;

import racingcar.enumeration.CarStatus;

public class ForwardString {
    private static final String FORWARD_STRING = "-";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final StringBuilder string;

    public ForwardString() {
        string = new StringBuilder();
    }

    public ForwardString(int carSize) {
        string = new StringBuilder(carSize + MAXIMUM_NAME_LENGTH);
    }

    public void setStringByCarStatus(CarStatus status) {
        if (status.equals(CarStatus.FORWARD)) {
            string.append(FORWARD_STRING);
        }
    }

    public String getString() {
        return string.toString();
    }
}
