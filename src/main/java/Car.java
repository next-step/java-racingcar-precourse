public class Car {

    private String carName;
    private int moveCount;

    public Car() {
        carName = "default";
        moveCount = 0;
    }

    public Car(String carName) {
        this.carName = carName;
        moveCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    private int generateNumber() {
        return (int) (Math.random() * 10);
    }

    public void move() {
        int number = generateNumber();

        if (number >= 4) {
            moveCount++;
        }
    }
}
