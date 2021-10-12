package racinggame;

import nextstep.utils.Console;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/12
 * @description :
 */
public class InputView {

  private static final String INPUT_CARNAMES_GUIDE_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : ";
  private static final String INPUT_RACINGTIME_GUIDE_MSG = "시도할 회수는 몇회인가요? ";

  public static String readCarNames() {
    System.out.println(INPUT_CARNAMES_GUIDE_MSG);
    return Console.readLine();
  }

  public static String readRacingTime() {
    System.out.println(INPUT_RACINGTIME_GUIDE_MSG);
    return Console.readLine();
  }

}
