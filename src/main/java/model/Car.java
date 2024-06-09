package model;

public class Car {
    private String name;
    private int position;
    private static final int FORWARD_CONDITION = 4;

    public Car(String name) {

        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomValue) { // 랜덤 숫자 값이 4 이상이면 차량 움직임 증가
        if (randomValue >= FORWARD_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) { // 차량 움직임 수 만큼 '-' 출력
            sb.append("-");
        }
        return sb.toString();
    }
}
