package RacingCar.View;

import RacingCar.util.InputValidator;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);
  public static List<String> getCarNames(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = scanner.nextLine();

    try{
      return InputValidator.checkCarValid(input);
    } catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return getCarNames();
    }
  }

  public static int getNumberOfAttempts(){
    System.out.println("시도할 회수는 몇회인가요?");
    String input = scanner.nextLine();

    try {
      return InputValidator.checkAttemptValid(input);
    } catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return  getNumberOfAttempts();
    }
  }
}
