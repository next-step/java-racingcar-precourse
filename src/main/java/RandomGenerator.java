import java.util.Random;

public class RandomGenerator {
    private static final int UPPER_BOUND = 10;

    private Random rand;

    public RandomGenerator() {
        this.rand = new Random();
    }

    public int get() {
        return this.rand.nextInt(UPPER_BOUND);
    }
}
