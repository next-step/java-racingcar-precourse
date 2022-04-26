package racingcar.model;

public class Car {

    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4 && number <= 9) {
            position = position + 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + getPositionStatus();
    }

    private String getPositionStatus() {
        StringBuffer status = new StringBuffer();
        for (int i = 0; i < position; i++) {
            status.append("-");
        }
        return status.toString();
    }
}
