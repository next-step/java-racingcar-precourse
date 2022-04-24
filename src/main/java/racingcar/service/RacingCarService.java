package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.util.RacingCarUtil;

public class RacingCarService {

  final String WIN_MESSAGE = "최종 우승자 : ";
  List<RacingCar> racingCarList = new ArrayList<>();

  public void start() {
    setCarNames(inputCars());
  }

  public void setCarNames(String carNames) {
    List<String> carNameList = RacingCarUtil.splitCarNames(carNames);
    try {
      for (String carName : carNameList) {
        RacingCarUtil.validationCarNameNull(carName);
        RacingCarUtil.validationCarNameLength(carName);
        racingCarList.add(new RacingCar(carName));
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e);
      racingCarList = new ArrayList<>();
      setCarNames(inputCars());
    }
    startGame();
  }

  public void startGame() {
    int gameCount = inputGameCount();
    for (int idx = 0; idx < gameCount; idx++) {
      racing();
    }
    racingWinPrint();
  }

  public void racingWinPrint() {
    System.out.println(WIN_MESSAGE + getCarName());
  }

  public void racing() {
    for (RacingCar racingCar : racingCarList) {
      int randomValue = RacingCarUtil.getRandomValue();
      if (RacingCarUtil.isGoOrStop(randomValue)) {
        RacingCar.addGoCount(racingCar, randomValue);
      }
      RacingCarUtil.racingCarsPrint(racingCar.getCarName(), racingCar.getGoCount());
    }
  }

  public String inputCars() {
    System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
    String carNaems = readLine();
    return carNaems;
  }

  public int inputGameCount() {
    System.out.println("시도할회수");
    String gameCount = readLine();
    return Integer.parseInt(gameCount);
  }


  public String getCarName() {
    RacingCar racingCar = racingCarList.get(0);
    String maxCarNames = RacingCarUtil.setCarName(null, racingCar.getCarName());
    for (int idx = 1; idx < racingCarList.size(); idx++) {
      RacingCar comparisonCar = racingCarList.get(idx);
      if (RacingCarUtil.isEqualRackingCar(racingCar, comparisonCar) && RacingCarUtil.isZero(
          comparisonCar)) {
        maxCarNames = RacingCarUtil.setCarName(racingCar.getCarName(), comparisonCar.getCarName());
        racingCar = comparisonCar;
      }
      if (RacingCarUtil.isMaxRackingCar(racingCar, comparisonCar)) {
        maxCarNames = RacingCarUtil.setCarName(null, comparisonCar.getCarName());
        racingCar = comparisonCar;
      }
    }
    return maxCarNames;
  }
}
