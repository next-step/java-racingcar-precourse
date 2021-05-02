package racing;

public class Car {
    private final String name;
    private Mileage mileage;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.mileage = new Mileage();
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

    private void validateName(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("CarName is too long");
        if (name.length() == 0) throw new IllegalArgumentException("CarName should exist");
    }

    private boolean isForwardable(Energy energy) {
        return energy.getLevel() >= 4;
    }
}
