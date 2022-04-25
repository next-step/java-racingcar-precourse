package racingcar;

public class CarPosition {

    private static final String TRACE_UNIT = "-";

    private int position;
    private String trace;

    public CarPosition() {
        this.position = 0;
        this.trace = "";
    }

    public boolean isStart() {
        return this.position == 0;
    }

    public void move() {
        this.position++;
        this.trace += TRACE_UNIT;
    }

    public int getPosition() {
        return this.position;
    }

    public String getTrace() {
        return this.trace;
    }

    public int compareTo(CarPosition carPosition) {
        return this.getPosition() - carPosition.getPosition();
    }
}
