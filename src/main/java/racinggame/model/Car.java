package racinggame.model;

public class Car {
    private String name;
    private long position;

    // Constructor
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // Getter
    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }

    // 앞으로 움직일 경우 위치 값 + 1
    public void moveForward() {
        position++;
    }
}
