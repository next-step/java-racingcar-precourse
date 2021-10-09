package racinggame.domain;

import racinggame.common.Constant;
import racinggame.common.enums.Messages;

import java.util.ArrayList;
import java.util.List;

public class CarFacroty {

    private String input;

    public CarFacroty(String input) {
        validName(input);

        this.input = input;
    }

    public void validName(String input) {
        String[] inputList = input.split(Constant.REGEX_COMMA);
        for (String str : inputList) {
            extracted(str);
        }
    }

    private void extracted(String str) {
        if (str.length() == Constant.INT_ZERO || str.length() >= Constant.INT_SIX) {
            throw new IllegalArgumentException(Messages.SIZE_CHECK.getMessage(Constant.STR_ERROR));
        }
    }

    public Cars enter() {
        List<Car> cars = new ArrayList<>();
        String[] inputList = input.split(Constant.REGEX_COMMA);
        for (String str : inputList) {
            cars.add(new Car(str));
        }
        return new Cars(cars);
    }
}
