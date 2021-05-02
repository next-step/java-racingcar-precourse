package racingcar;

public class Car {

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int move(int randomnumber) {
        if(randomnumber >= 4) {
            this.position = position + 1;
        }

        return position;
    }
}
