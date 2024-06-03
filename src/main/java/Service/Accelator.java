package Service;

import java.util.Random;

public class Accelator {
    private Random random = new Random();
    private static final int CUTOFF = 4;
    boolean accel(){
        if(random.nextInt(10) >= CUTOFF){
            return true;
        }
        return false;
    }
}
