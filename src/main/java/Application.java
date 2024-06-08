import DTO.CarDTO;
import service.RacingService;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    RacingService racingService = new RacingService();

    // 자동차 이름 입력받기
    String[] carNames = inputView.getCarNames();

    // 시도할 회수 입력받기
    int attempts = inputView.getAttempts();

    // 게임 초기화
    racingService.initializeGame(carNames);

    // 시도할 회수만큼 레이스 실행
    for (int i = 0; i < attempts; i++) {
      racingService.race(1);
      List<CarDTO> carStatuses = racingService.getCarStatuses();
      resultView.printRaceStatus(carStatuses);
    }

    // 우승자 출력
    List<String> winners = racingService.getWinners();
    resultView.printWinners(winners);
  }
}
