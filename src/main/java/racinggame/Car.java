package racinggame;

import nextstep.utils.Randoms;

import static racinggame.Status.*;

public class Car {
    private String name;
    private int position;
    private Status status;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.status = WAIT;
    }

    public String getName() {
        return name;
    }

    public void moved(int randomNumber) {
        checkNumber(randomNumber);
        moveExcute();
    }

    private void moveExcute() {
        if(status == FORWARD)
            position++;
    }

    private void checkNumber(int number) {
        if(number >= 4)
            status = FORWARD;
        if(number <= 3)
            status = STOP;
    }

    public int getPosition() {
        return position;
    }
}
