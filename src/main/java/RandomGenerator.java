import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();

    public int makeRandNum() {
        //0~9
        return random.nextInt(10);
    }
}
