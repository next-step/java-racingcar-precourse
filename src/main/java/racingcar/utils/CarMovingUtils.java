package racingcar.utils;

public class CarMovingUtils {

    private static final int GO_NUM = 4;

    public static boolean isGo(int randomMovingNum) {
        if(randomMovingNum >= GO_NUM) {
            return true;
        }
        return false;
    }
}
