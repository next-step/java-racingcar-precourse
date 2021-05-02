package racing;

public class Car {
    public static final String DELIMITER_NAME_MILEAGE = ":";
    private final String name;
    private final Mileage mileage;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.mileage = new Mileage();
    }

    public String getName() {
        return name;
    }

    public Mileage getMileage() {
        return this.mileage;
    }

    public void injectEnergy(Energy energy) {
        if (isForwardable(energy)) {
            this.mileage.increase();
        }
    }

    @Override
    public boolean equals(Object other) {
        return Comparison.Equals(this, other, car -> name.equals(car.name));
    }

    @Override
    public String toString() {
        return name + DELIMITER_NAME_MILEAGE + mileage.getValueAsDash();
    }

    private void validateName(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("CarName is too long");
        if (name.length() == 0) throw new IllegalArgumentException("CarName should exist");
    }

    private boolean isForwardable(Energy energy) {
        return energy.getLevel() >= 4;
    }
}
