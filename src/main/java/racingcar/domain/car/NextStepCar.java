package racingcar.domain.car;

import racingcar.domain.engine.NextStepEngine;
import racingcar.generator.NextStepFuelGenerator;
import racingcar.validator.name.NextStepValidatorName;

public class NextStepCar extends Car {

    public NextStepCar(String name){
        super(name, new NextStepEngine(new NextStepFuelGenerator()), new NextStepValidatorName());
    }

}
