package racinggame;

import java.util.NoSuchElementException;
import nextstep.utils.Console;
import racinggame.enums.Errors;
import racinggame.model.RacingCar;

public class RacingCarGame {

  private RacingCar racingCar;
  private int attemptCnt;

  public void start() {
    inputCarName();
    inputAttemptCnt();
    System.out.println();

    play();
    System.out.println("최종 우승자는 " + racingCar.winner() + " 입니다.");
  }

  private void inputCarName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    try {
      racingCar = new RacingCar(Console.readLine());
    } catch (Exception ex) {
      Errors.println(ex.getMessage());
      throw new NoSuchElementException();
    }
  }

  private void inputAttemptCnt() {
    System.out.println("시도할 회수는 몇회인가요?");
    try {
      attemptCnt = Integer.parseInt(Console.readLine());
    } catch (Exception ex) {
      Errors.println(ex.getMessage());
      throw ex;
    }
  }

  private void play() {
    System.out.println("실행 결과");
    for (int i = 0; i < attemptCnt; i++) {
      racingCar.race();
      racingCar.getLocationOfCars()
          .forEach((k, v) -> System.out.println(k + " : " + convertNumToBar(v)));
      System.out.println();
    }
  }

  private String convertNumToBar(int barCnt) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < barCnt; i++) {
      builder.append("-");
    }

    return builder.toString();
  }
}
