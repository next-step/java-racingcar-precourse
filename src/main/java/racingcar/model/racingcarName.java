package racingcar.model;

import racingcar.utils.exceptionMessage;

public class racingcarName {
    private final String carName;
    private exceptionMessage message = new exceptionMessage();

    public racingcarName(String carName) {
        validationcheckNameLength(carName);
        this.carName = carName;
    }
    private void validationcheckNameLength(String carName) {
        if(carName.length() == 0)
            throw new IllegalArgumentException(message.noInputCarName());
        if(carName.length()>5)
            throw new IllegalArgumentException(message.InputCarName5Over());
    }
    public String getCarName() {
        return carName;
    }
}
