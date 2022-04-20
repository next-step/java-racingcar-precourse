package racingcar.domain;

public class Car {

    private final Name name;
    private final DistanceLog driveLog = new DistanceLog();

    public Car(String name) {
        this.name = new Name(name);
    }

    public void drive(int factor) {
        driveLog.record(factor);
    }

    public String calcMileageAsSymbol() {
        return driveLog.calcMileageAsSymbol();
    }

    public int calcMileage() {
        return calcMileageAsSymbol().length();
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, calcMileageAsSymbol());
    }
}
