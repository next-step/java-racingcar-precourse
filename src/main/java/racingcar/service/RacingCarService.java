package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.RacingCarUtil;

public class RacingCarService {

  public void start() {
//    List<String> carNameList = RacingCarUtil.splitCarNames(inputCars());
    inputCars();
    inputGameCount();
    //null check
    //lengthcheck
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

  public void gameStart(){

  };
}
