package RacingCar.Controller;

import RacingCar.View.InputView;
import java.util.List;

public class RacingCarController {

  public static void startGame(){
    List<String> carNames = InputView.getCarNames();

    int attempts;

    try {
      attempts = InputView.getNumberOfAttempts();
    } catch (NumberFormatException e){
      throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
    }
  }
}
