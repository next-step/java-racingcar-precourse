package racingcar.domain.car;

import racingcar.config.Message;
import racingcar.domain.car.component.*;
import racingcar.domain.engine.Engine;
import racingcar.validator.name.ValidatorName;

public class Car implements Comparable<Car> {

    private Engine engine;
    private CarName carName;
    private CarLocation carLocation;

    public Car(String name, Engine engine, ValidatorName validator){
        this.carName = new CarName(name, validator);
        this.carLocation = new CarLocation();
        this.engine = engine;
    }

    public void move(){
        if(engine.move()){
            carLocation.moveForward();
        }
    }

    public int getLocation(){
        return carLocation.getLocation();
    }

    public String getName(){
        return carName.getName();
    }

    @Override
    public int compareTo(Car car) {
        if(this.getLocation() < car.getLocation()){
            return 1;
        }
        if(this.getLocation() > car.getLocation()){
            return -1;
        }

        return this.getName().compareTo(car.getName());
    }

    @Override
    public String toString() {
        return String.format(Message.FORMAT_CAR_PRINT, carName.toString(), carLocation.toString());
    }
}
