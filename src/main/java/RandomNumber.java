import java.util.Random;

public class RandomNumber {

    final static int UPPER_BOUND_ZERO_2_NINE = 10;
    
    public static int getZero2Nine() {
        Random rand = new Random();
        return rand.nextInt(UPPER_BOUND_ZERO_2_NINE);
    }
}
