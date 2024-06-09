package utility;

import java.util.Random;

public class Fortuna {
    public static boolean isForward(){
        Random random = new Random();
        if(random.nextInt(10) < 4)
            return false;
        return true;
    }
}
