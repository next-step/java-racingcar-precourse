package racinggame.domain;

import racinggame.common.Constant;
import racinggame.common.enums.Messages;

import java.util.*;

public class CarFacroty {

    private final String inputName;

    public CarFacroty(String inputName) {
        validSizeName(inputName);
        validDuplicateName(inputName);

        this.inputName = inputName;
    }

    public void validSizeName(String input) {
        String[] inputArray = input.split(Constant.REGEX_COMMA);
        for (String str : inputArray) {
            validString(str);
        }
    }

    private void validString(String str) {
        if (str.length() == Constant.INT_ZERO || str.length() >= Constant.INT_SIX) {
            throw new NoSuchElementException(Messages.CAR_SIZE_CHECK.getMessage(Constant.STR_ERROR));
        }
    }

    public void validDuplicateName(String input) {
        String[] inputArray = input.split(Constant.REGEX_COMMA);
        Set<String> inputSet = new HashSet<>(Arrays.asList(inputArray));
        if( inputArray.length != inputSet.size() ) {
            throw new NoSuchElementException(Messages.DUPL_CHECK.getMessage(Constant.STR_ERROR));
        }
    }

    public Cars enter() {
        List<Car> cars = new ArrayList<>();
        String[] inputNameList = inputName.split(Constant.REGEX_COMMA);
        for (String str : inputNameList) {
            cars.add(new Car(str));
        }
        return new Cars(cars);
    }
}
