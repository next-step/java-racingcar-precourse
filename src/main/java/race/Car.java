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

    public void tryMove() {
        int randomNumber = random.nextInt(RANDOM_MAX + 1);
        if (randomNumber >= MOVE_THRESHOLD) {
            ++moveCount;
        }
    }

    public void move() {

    }
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
