package racingcar.car;

public class CarPosition {
    private static final String FORWARD_TEXT = "-";

    private String text;
    private int number;

    public CarPosition() {
        this.number = 0;
        this.text = "";
    }

    public void moveForward() {
        this.text = this.text + FORWARD_TEXT;
        this.number = this.text.length();
    }

    public int toNumber() {
        return this.number;
    }

    public String toResultText() {
        return this.text;
    }
}
