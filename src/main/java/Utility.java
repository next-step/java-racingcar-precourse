import java.util.Random;

public class Utility {

    public static final int BOUND = 10;

    public static Integer generateRandomSingleDigitInteger() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
