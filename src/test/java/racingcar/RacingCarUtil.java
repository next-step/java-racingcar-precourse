package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class RacingCarUtil {


  public static final int GO_STATUS = 4;
  static final String CAR_NULL_MESSAGE = "[ERROR] 자동차 이름을 입력해주세요.";
  static final String CAR_LENGTH_MESSAGE = "[ERROR] 자동차 이름을  5자 이하로 입력해주세요.";
  public static final int MAX_CAR_NAME_LENGTH = 5;

  public static boolean isGoOrStop(int cnt) {
    if (isGo(cnt)) {
      return true;
    }
    return false;
  }

  public static boolean isGo(int cnt) {
    return cnt >= GO_STATUS;
  }

  public static String getCarName(List<RacingCar> racingCarList) {//서비스로 옮겨야함
    RacingCar racingCar = racingCarList.get(0);
    String maxCarNames = setCarName(null, racingCar.getCarName());
    for (int idx = 1; idx < racingCarList.size(); idx++) {
      RacingCar comparisonCar = racingCarList.get(idx);
      if (isEqualRackingCar(racingCar, comparisonCar) && isZero(comparisonCar)) {
        maxCarNames = setCarName(racingCar.getCarName(), comparisonCar.getCarName());
        racingCar = comparisonCar;
      }
      if (isMaxRackingCar(racingCar, comparisonCar)) {
        maxCarNames = setCarName(null, comparisonCar.getCarName());
        racingCar = comparisonCar;
      }
    }
    return maxCarNames;
  }

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

  public static boolean isZero(RacingCar comparisonCar) throws IllegalArgumentException {
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
}
