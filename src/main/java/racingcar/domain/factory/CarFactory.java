package racingcar.domain.factory;

import racingcar.config.Message;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.engine.Engine;
import racingcar.validator.name.ValidatorName;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private Engine engine;
    private ValidatorName validator;

    public CarFactory setEngine(Engine engine){
        this.engine = engine;
        return this;
    }

    public CarFactory setValidatorName(ValidatorName validator){
        this.validator = validator;
        return this;
    }

    public Cars makeCar(String input) throws IllegalArgumentException {
        if (!input.contains(Message.FORMAT_SPLIT)) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_CAR_NAME);
        }

        List<Car> carList = new ArrayList<>();
        String[] split = input.split(Message.FORMAT_SPLIT);

        for (String name : split) {
            carList.add(getCar(name.trim()));
        }

        return new Cars(carList);
    }

    public Car getCar(String name){
        if(engine == null){
            throw new IllegalStateException(Message.ERROR_ENGINE_NULL);
        }
        if(validator == null){
            throw new IllegalStateException(Message.ERROR_VALIDATOR_NULL);
        }
        return new Car(name, engine, validator);
    }

}
