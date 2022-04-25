package racingcar.car;

public class Car {

    private final CarName name;

    private Car(CarName name) {
        this.name = name;
    }

    public static Car of(CarName name) {
        return new Car(name);
    }

    public CarName name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }

        return ((Car) o).name().equals(this.name());
    }

    @Override
    public int hashCode() {
        return this.name().hashCode();
    }

}
