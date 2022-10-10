package racingcar.domain;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    public Car(String name){
        CarName carName = new CarName(name);
        CarPosition carPosition = new CarPosition(0);
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public CarName getCarName(){
        return this.carName;
    }

    public CarPosition getCarPosition(){
        return this.carPosition;
    }

}
