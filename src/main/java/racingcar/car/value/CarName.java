package racingcar.car.value;

import racingcar.common.exception.ErrorMessage;

import java.util.Objects;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validation(name);
        this.name = name;
    }

    public String value() {
        return name;
    }

    private void validation(String name){
        if(name.length()<=0 || name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
