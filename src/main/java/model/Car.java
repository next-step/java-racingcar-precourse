package model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if(name == null || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }
}
