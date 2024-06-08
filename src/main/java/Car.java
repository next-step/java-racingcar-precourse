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

    public int generateNumber() {
        return (int)(Math.random() * 10);
    }
}
