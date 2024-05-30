package domain;

public class RacingCar {

    final static int MAX_NAME_LENGTH = 5;

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static boolean isValidName(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }
}
