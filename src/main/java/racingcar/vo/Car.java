package racingcar.vo;


public class Car implements Comparable<Car> {
    private Name name;
    private Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = new Position();
        this.position = position;
    }

    public Car() {

    }

    public Name getCarName() {
        return name;
    }

    public void setCarName(Name name) {
        this.name = name;
    }

    public Position getCurrentPosition() {
        return position;
    }

    public void printCar() {
        System.out.print(getCarName().getName() + " : ");
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Car o) {
        if (this.position.getPosition() > o.getCurrentPosition().getPosition()) {
            return -1;
        }

        if (this.position.getPosition() < o.getCurrentPosition().getPosition()) {
            return 1;
        }

        return 0;
    }
}
