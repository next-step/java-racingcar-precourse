package racingcar.domain.car.component;

import racingcar.validator.name.ValidatorName;

public class CarName {
    private String name;

    public CarName(String name, ValidatorName validator){
        validator.validateCarsName(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
