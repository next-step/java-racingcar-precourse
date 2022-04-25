package racingcar.domain;

public class Car {

    private static int FORWARD_COUNT = 4;
    private static int START_POSITION_COUNT = 0;
    private static String DELIMITER = " : ";

    private CarName name;
    private CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition(START_POSITION_COUNT);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(int number) {
        if (number >= FORWARD_COUNT) {
            position.addPosition();
        }
    }

    public boolean isEqual(Car car) {
        return this.name.equals(car.getName());
    }

    public String print() {
        return this.name.getName() + DELIMITER + position.print();
    }

}
