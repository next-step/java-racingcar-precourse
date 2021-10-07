package racinggame.utils;

public class MoveUtils {
    public static final int STANDARD_NO = 3;

    public static boolean isGo(int n) {
        if(n > STANDARD_NO) {
            return true;
        }
        return false;
    }
}
