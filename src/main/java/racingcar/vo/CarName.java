package racingcar.vo;

import racingcar.constant.Config;
import racingcar.constant.Message;

public class CarName extends Base {
    private String carName;

    public CarName(String input) {
        super(input);
    }

    public String getCarName() {
        return carName;
    }

    @Override
    protected void validate() {
        if (this.input.length() > Config.MAX_CAR_NAME) {
            throw new IllegalArgumentException(Message.ERROR_INVLAID_CAR_NAMES);
        }
        this.carName = this.input;
    }
}
