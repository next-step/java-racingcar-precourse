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

    public void carNameIsOverSize(String input) throws IllegalArgumentException {
        String[] split = input.split(",");
        for (String s : split) {
            if (s.length() > 6) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
