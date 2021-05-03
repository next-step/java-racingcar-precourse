package racing.view;

import java.util.Scanner;

public final class InputView {
  private static final Scanner scanner = new Scanner(System.in);
  private static final String QUESTION_OF_INPUT_PLAYER_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String QUESTION_OF_INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";

  private InputView() {

  }

  public static String getPlayerNames() {
    System.out.println(QUESTION_OF_INPUT_PLAYER_NAMES);
    return scanner.nextLine();
  }

  public static int getTryNumber() {
    System.out.println(QUESTION_OF_INPUT_TRY_NUMBER);
    return Integer.parseInt(scanner.nextLine());
  }
}
