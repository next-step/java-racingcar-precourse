package race;

import java.util.Random;
import static race.Parameters.RANDOM_MAX;
import static race.Parameters.MOVE_THRESHOLD;

public class Car {
    private String name;
    private int moveCount;
    private Random random;
    public Car(String name) {
        this.name = name;
        moveCount = 0;
        random = new Random();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    /**
     * 랜덤한 숫자를 생성하여 전진 또는 멈춤
     */
    public void tryMove() {
        int randomNumber = random.nextInt(RANDOM_MAX + 1);
        if (randomNumber >= MOVE_THRESHOLD) {
            ++moveCount;
        }
    }

    /**
     * @return 자동차의 이름과 현재 이동 상태
     */
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
