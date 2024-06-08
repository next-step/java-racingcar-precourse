package domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveCar() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            position++;
        }
    }
}
