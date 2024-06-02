package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        // 자동차 이름은 5자 이하만 가능하다.
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
        this.name = name;
    }

    public void move(int randomNumber) {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
