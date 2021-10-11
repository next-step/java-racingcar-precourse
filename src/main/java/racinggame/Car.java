package racinggame;

public class Car {
    private CarName carName;
    private CarPosition carPosition;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition();
    }

    public void move(boolean ok) {
        if(ok){
            this.carPosition.next();
        }
    }
}
