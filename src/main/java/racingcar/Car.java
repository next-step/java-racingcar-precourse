package racingcar;

public class Car implements Comparable<Car> {
    private String position;
    private int positionIndex;
    private String name;

    public Car(String name) {
        this.position = "";
        this.name = name;
        this.positionIndex = 0;
    }

    @Override
    public int compareTo(Car o) {
        return o.positionIndex - this.positionIndex;
    }

    public void move(GoStop goStop) {
        if (goStop.isGo()) {
            this.position = position + "-";
            this.positionIndex = positionIndex + 1;
        }
    }

    public String getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPositionIndex() {
        return this.positionIndex;
    }
}
