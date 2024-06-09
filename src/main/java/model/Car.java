package model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void initializePosition() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }
}
