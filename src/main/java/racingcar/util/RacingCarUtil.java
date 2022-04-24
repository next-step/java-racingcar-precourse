package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.domain.RacingCar;

public class RacingCarUtil {

  public static final int GO_STATUS = 4;
  static final String CAR_NULL_MESSAGE = "[ERROR] 자동차 이름을 입력해주세요.";
  static final String CAR_LENGTH_MESSAGE = "[ERROR] 자동차 이름을  5자 이하로 입력해주세요.";
  public static final int MAX_CAR_NAME_LENGTH = 5;
  static final int MIN_RANDOM_VALUE = 0;
  static final int MAX_RANDOM_VALUE = 9;



  public static int getRandomValue() {
    return assertNumber(Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE));
  }

  public static int assertNumber(int number) {
    if (number < 0 || number > 9) {
      throw new IllegalArgumentException();
    }
    return number;
  }
  public static boolean isGoOrStop(int cnt) {
    if (isGo(cnt)) {
      return true;
    }
    return false;
  }

  public static boolean isGo(int cnt) {
//    if() {
//
//    }
    return cnt >= GO_STATUS;
  }

//  public static boolean isNumber() {
//
//  }

  public static List<String> splitCarNames(String carNames) {
    return Arrays.asList(carNames.split(","));
  }

  public static void validationCarNameNull(String carName) throws IllegalArgumentException {
    if(StringUtils.isBlank(carName)) {
      throw new IllegalArgumentException(CAR_NULL_MESSAGE);
    }
  }

  public static void validationCarNameLength(String carName) throws IllegalArgumentException {
    if(carName.length() > MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(CAR_LENGTH_MESSAGE);
    }
  }

  public static boolean isZero(RacingCar comparisonCar) {
    if (comparisonCar.getGoCount() != 0) {
      return true;
    }
    return false;
  }

  public static boolean isMaxRackingCar(RacingCar racingCar, RacingCar comparisonCar) {//기존
    if (racingCar.getGoCount() < comparisonCar.getGoCount()) {
      return true;
    }
    return false;
  }

  public static boolean isEqualRackingCar(RacingCar racingCar, RacingCar comparisonCar) {
    if (racingCar.getGoCount() == comparisonCar.getGoCount()) {
      return true;
    }
    return false;
  }

  public static String setCarName(String carName, String addCarName) {
    if (StringUtils.isNotBlank(carName)) {
      return carName + ", " + addCarName;
    }
    return addCarName;
  }

  public static void racingCarsPrint(String carName, int cnt) {
    System.out.println(carName + " : " + cntToDash(cnt));
  }

  public static String cntToDash(int cnt){
    String dash = "";
    for(int idx = 0; idx < cnt; idx++) {
      dash+="-";
    }
    return dash;
  }
}
