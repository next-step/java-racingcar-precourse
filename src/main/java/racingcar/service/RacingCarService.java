package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.util.RandomUtil;
import racingcar.view.OutputView;

public class RacingCarService {

  private Race race;

  public RacingCarService(List<Car> cars, Integer gameCount) {
   race = new Race(cars, gameCount);
  }

  public void start() {
    roundResult();
    winner();
  }
  private void roundResult() {
    for (int idx = 0; idx < race.getRound(); idx ++) {
      setCarDistance(race.getCars());
    }
  }

  private void setCarDistance(List<Car> cars) {
    for (Car car : cars) {
      car.isMove(RandomUtil.getRandomNumber());
      System.out.println(car.getResultMessage());
      OutputView.roundResult(car.getResultMessage());
    }
  }

  private void winner() {
    OutputView.winnerResult(race.getChampionName());
  }
}
