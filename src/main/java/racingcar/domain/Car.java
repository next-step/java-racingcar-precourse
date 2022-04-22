package racingcar.domain;

public class Car {

    private final Name name;
    private Distance mileage = Distance.valueOf(0);

    public Car(String name) {
        this.name = new Name(name);
    }

    public void drive(int factor) {
        final Distance distance = Distance.fromFactor(factor);
        setMileage(mileage.add(distance));
    }

    public String getMileageAsSymbol() {
        return mileage.getValueAsSymbol();
    }

    public Distance getMileage() {
        return mileage;
    }

    public Name getName() {
        return name;
    }

    private void setMileage(Distance mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getMileageAsSymbol());
    }
}
