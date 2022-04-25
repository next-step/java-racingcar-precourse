package racingcar.domain.factory;

import racingcar.domain.car.Car;
import racingcar.domain.car.NextStepCar;

public class NextStepCarFactory extends CarFactory{

    @Override
    public Car getCar(String name){
        return new NextStepCar(name);
    }

}
