package racingcar.domain;

public class Car {
    
    public static final int SPEED = 1;
    
    private final CarName carName;
    private final Distance distance = new Distance();

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(String carName) {
        return new Car(new CarName(carName));
    }

    public void move() {
        distance.plus(SPEED);
    }

    public String getName() {
        return carName.getName();
    }

    public Distance getDistance() {
        return distance;
    }
 
    public String getStatus() {
        return String.format("%s : %s", carName.getName(), distance.getProgressBar());
    }
}