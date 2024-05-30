package model;

public class Car {
    private String name;
    private int position;


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        this.position++;
    }
}
