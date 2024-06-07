package domain;

import java.util.List;

public class RacingCar {

    private final String name;

    private Long position;

    private RacingCar(String name) {
        this.name = name;
        this.position = 0L;
    }

    /**
     * 생성 메서드
     */
    public static List<RacingCar> create(RacingCarCommand.Create create) {
        return create.name().stream()
            .map(RacingCar::new)
            .toList();
    }

    /**
     * 비즈니스 메서드
     */
    public void move() {
        if (isForward()) {
            position++;
        }
    }

    /**
     * racing car가 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
     */
    private boolean isForward() {
        return Math.floor(Math.random() * 10) >= 4;
    }

}
