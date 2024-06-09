package model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0; // 생성자에서 위치를 초기화
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
