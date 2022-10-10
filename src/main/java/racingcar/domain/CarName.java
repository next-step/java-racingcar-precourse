package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class CarName  {
    public static final int NAME_MAX_LENGTH = 6;

    private String name;


    public CarName() {
    }

    public CarName(String name){
        if (name == null || name.equals("") ){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.getMessage());
        }
        if (!validCarNameLength(name)) {
           throw new IllegalArgumentException(ErrorMessage.CAR_NAME_RANGE_ERROR.getMessage());
        }

        this.name = name;
    }

    public boolean validCarNameLength(String carName) {
        return carName.length() < NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
