package racingcar.vo;

public class Position {
    private int position;

    public Position() {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setStartPosition() {
        this.position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addCurrentSpeed(int currentSpeed) {
        this.position = this.position + currentSpeed;
    }
}