package racinggame.car;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public void decideMove(int randomNumber) {
        if (isMovable(randomNumber)) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    private boolean isMovable(int number) {
        return number >= 4;
    }
}
