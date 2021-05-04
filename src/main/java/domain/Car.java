package domain;

import validation.CarValidation;

public class Car {
    private final String name;
    private int position = 0;
    private boolean isWinner = false;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    public void setIsWinner() {
        isWinner = true;
    }

    public void forward() {
        if (Rule.isforward()) {
            position++;
        }
    }
}
