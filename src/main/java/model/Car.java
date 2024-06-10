package model;

public class Car {
    final private String name;
    private int pos;

    public Car(String name) {
        if (5 < name.length()) {
            throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다");
        }
        this.name = name;
        this.pos = 0;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void move() {
        int randomNumber = (int)(Math.random() * 10);
        if (4 <= randomNumber) {
            pos++;
        }
    }
}
