package racing;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("CarName is too long");
        if (name.length() == 0) throw new IllegalArgumentException("CarName should exist");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        Car car = (Car) other;
        return name.equals(car.name);
    }
}
