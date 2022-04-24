package racingcar.domain;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public Position getPosition() {
        return position;
    }

    public void tryToMove(Standard standard) {
        if (standard.isMovable()) {
            move();
        }
    }

    private void move() {
        position.goForward();
    }

    public boolean isAtThePosition(Position comparison) {
        return this.position.equals(comparison);
    }
    
    public void print() {
        System.out.println(name + " : " + position);
    }

    public String getNameToString() {
        return name.toString();
    }

    @Override
    public int compareTo(Car o) {
        return Position.compare(this.position, o.getPosition());
    }
}
