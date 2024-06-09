package racing.model;

import java.util.Random;

/**
 * 자동차 클래스.
 * 각 자동차는 이름과 위치를 가진다.
 */
public class Car {
    private final String name;  // 자동차 이름
    private int position; // 현재 위치

    /**
     * 생성자.
     * @param name 자동차 이름. 5자 이하만 가능.
     */
    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    /**
     * 자동차를 전진시킴.
     * 0에서 9 사이의 무작위 값이 4 이상일 경우 전진.
     */
    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    /**
     * 무작위 값이 4 이상인지 확인.
     * @return 4 이상이면 true, 그렇지 않으면 false
     */
    private boolean isMovable() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber >= 4;
    }

    /**
     * 자동차 이름 반환.
     * @return 자동차 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 현재 위치 반환.
     * @return 현재 위치
     */
    public int getPosition() {
        return position;
    }

    /**
     * 자동차의 현재 상태 문자열로 반환.
     * @return 현재 상태
     */
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
