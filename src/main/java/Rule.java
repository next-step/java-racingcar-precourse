import java.util.Random;

public class Rule {
    public void randomAdvanceOrStop(Car car) {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            car.advance();
        }
    }
}
