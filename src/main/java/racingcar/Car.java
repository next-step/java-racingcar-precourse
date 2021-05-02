package racingcar;

public class Car {
    private String position;

    public Car(String position) {
        this.position = position;
    }

    public String move(int randomnumber) {
        if(randomnumber >= 4) {
            this.position = position + "-";
        }

        return position;
    }
}
