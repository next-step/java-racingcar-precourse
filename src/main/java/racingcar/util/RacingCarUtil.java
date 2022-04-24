package racingcar.util;

public class RacingCarUtil {

  public static final int GO_STATUS = 4;

  public static boolean isGoOrStop(int cnt) {
    if(isGo(cnt)) return true;
    return false;
  }

  public static boolean isGo(int cnt) {
    return cnt >= GO_STATUS;
  }

}
