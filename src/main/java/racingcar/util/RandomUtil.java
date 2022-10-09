package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

  private final static  Integer START_NUMBER = 0;
  private final static  Integer END_NUMBER = 9;
  public static Integer getRandomNumber() {
    return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
  }
}
