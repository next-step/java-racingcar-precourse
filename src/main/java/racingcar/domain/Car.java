package racingcar.domain;

import java.util.Comparator;

public class Car {
    public static final int STOP_MAX_VALUE = 3;
    public static final int MOVE_MIN_VALUE = 4;
    public static final int CHECK_MAX_VALUE = 9;

    public static final Comparator DISTANCE_COMPARATOR = new DistanceComparator();
    private final CarName carName;
    private final Movement movement;


    public Car(CarName carName, Movement movement) {
        this.movement = movement;
        this.carName = carName;
    }

    public Car(String carName) {
        this(new CarName(carName), new Movement());
    }

    public void drive(int value) {
        if(value >= MOVE_MIN_VALUE && value <= CHECK_MAX_VALUE){
            this.movement.moving();
        }
    }

    public int mileage() {
        return this.movement.getDistance();
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public String printRacingState() {
        String result = this.getCarName() + " : ";
        for (int i=0; i < this.mileage(); i++){
            result += "-";
        }

        return result;
    }
}
