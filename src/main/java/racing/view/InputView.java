package racing.view;

import java.util.Scanner;

public class InputView {

  private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";
  public static final String DELIMITER = ",";

  private static Scanner SCANNER = new Scanner(System.in);

  public String[] getCarNames() {
    System.out.println(QUESTION_CAR_NAMES);
    String names = SCANNER.nextLine();
    return names.split(DELIMITER);
  }

  public int getTryCount() {
    System.out.println(QUESTION_TRY_COUNT);
    return SCANNER.nextInt();
  }

}
