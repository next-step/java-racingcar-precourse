package com.game.racingCar;

import com.game.global.exception.CarsException;

import static com.game.global.code.CarsExceptionType.*;
import static com.game.global.config.RacingCarConfig.*;
import static java.lang.String.format;

public class RacingCar implements Comparable<RacingCar> {

    private String name;
    private Integer location;


    public RacingCar(String carName) {
        validateCarName(carName);
        this.name = carName;
        this.location = RACING_START_LINE;
    }


    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }

    public void goForward(Integer value) {
        validateInputValue(value);

        if (value >= GO_FORWARD_STANDARD) {
            location++;
        }

        printCurrentLocation();
    }

    public boolean compareLocation(RacingCar target) {
        return this.location.compareTo(target.getLocation()) == 0;
    }

    @Override
    public int compareTo(RacingCar target) {
        int result = Integer.compare(target.location, this.location);
        if (result == 0) {
            result = this.name.compareTo(target.name);
        }
        return result;
    }


    private void printCurrentLocation() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(": ");
        for (Integer i = 0; i < this.location; i++) {
            stringBuffer.append("-");
        }
        System.out.println(stringBuffer.toString());
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.length() == 0) {
            throw new CarsException(EMPTY_CAR_NAME, format(EMPTY_CAR_NAME.getDescription()));
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarsException(OVERSIZE_CAR_NAME,
                    format(OVERSIZE_CAR_NAME.getDescription(), carName, MAX_CAR_NAME_LENGTH));
        }
    }

    private void validateInputValue(Integer value) {
        if (value < 0 || value > 9) {
            throw new CarsException(WRONG_CAR_GO_FORWARD_VALUE,
                    format(WRONG_CAR_GO_FORWARD_VALUE.getDescription(), value));
        }
    }

}
