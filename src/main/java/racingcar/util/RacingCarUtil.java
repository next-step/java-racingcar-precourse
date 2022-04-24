package racingcar.util;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.domain.RacingCar;

public class RacingCarUtil {

  public static final int GO_STATUS = 4;

  public static boolean isGoOrStop(int cnt) {
    if (isGo(cnt)) {
      return true;
    }
    return false;
  }

  public static boolean isGo(int cnt) {
    return cnt >= GO_STATUS;
  }

  public static String getCarName(List<RacingCar> racingCarList) {
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

  //0 인지 체크
  private static boolean isZero(RacingCar comparisonCar) {
    if (comparisonCar.getGoCount() != 0) {
      return true;
    }
    return false;
  }

  private static boolean isMaxRackingCar(RacingCar racingCar, RacingCar comparisonCar) {//기존
    if (racingCar.getGoCount() < comparisonCar.getGoCount()) {
      return true;
    }
    return false;
  }

  private static boolean isEqualRackingCar(RacingCar racingCar, RacingCar comparisonCar) {
    if (racingCar.getGoCount() == comparisonCar.getGoCount()) {
      return true;
    }
    return false;
  }

  private static String setCarName(String carName, String addCarName) {
    if (StringUtils.isNotBlank(carName)) {
      return carName + ", " + addCarName;
    }
    return addCarName;
  }
}
