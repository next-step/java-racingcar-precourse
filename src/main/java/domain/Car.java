package domain;

public class Car {

    private final String name;
    private int advanceNumber;
    private static final int INITIAL_STATUS_NUMBER = 0;

    public Car(String name) {
        this.name = name;
        this.advanceNumber = INITIAL_STATUS_NUMBER;
    }

    public void advance() {
        advanceNumber++;
    }

    public String getName() {
        return name;
    }

    public int getAdvanceNumber() {
        return advanceNumber;
    }

    public String getStatus() {
        return "-".repeat(advanceNumber);
    }
}
