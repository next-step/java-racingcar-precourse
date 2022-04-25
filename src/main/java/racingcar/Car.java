package racingcar;

public class Car {
    private final String name;
    private int mileage = 0;


    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public Car(String name) {
        ValidUtils.validLength(name);
        this.name = name;
    }

    public void drive(int number) {
        if (CarStatus.from(number).isGo()) {
            this.mileage++;
        }
    }

}
