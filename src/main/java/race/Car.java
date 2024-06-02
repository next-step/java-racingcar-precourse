package race;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
