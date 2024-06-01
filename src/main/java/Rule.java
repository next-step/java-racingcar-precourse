import java.util.Random;

public class Rule {
    public void randomAdvanceOrStop(Car car) {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            car.advance();
        }
    }

    public void carNameIsNull(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 자동자 이름이 비어있습니다.");
        }
    }
}
