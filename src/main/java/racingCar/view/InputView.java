package racingCar.view;

import java.util.Scanner;

public class InputView {

  private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final Scanner scanner = new Scanner(System.in);

  public static String[] inputCarNames() {
    System.out.println(CAR_QUESTION);
    return inputNames();
  }

  private static String[] inputNames() {
    String carNames = scanner.next();
    return carNames.split(",");
  }


}
