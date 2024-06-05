package domain;

public class Car {

    private String name;
    private int moveCount;

    public static Car from(String name) {
        return new Car(name, 0);
    }

    protected Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void move() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
