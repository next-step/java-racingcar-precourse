package racingcar;

public class Position {

    private static final String pathUnit = "-";
    private int position = 0;
    private String path = "";

    Position() {
    }

    int getPosition() {
        return position;
    }

    private void setPosition(int position) {
        this.position = position;
    }

    void moveForward() {
        increasePositionByOne();
        increasePathByOne();
    }

    private void increasePathByOne() {
        setPath(getPath() + pathUnit);
    }

    private void setPath(String path) {
        this.path = path;
    }

    String getPath() {
        return path;
    }

    private void increasePositionByOne() {
        setPosition(getPosition() + 1);
    }

}
