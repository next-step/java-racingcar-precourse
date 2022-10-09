package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

  private RacingCarService racingCarService;
  final Integer DISTANCE = 0;
  final String MARK = "";
  public void run() {
    List<String> carNames = setCarNames();
    Integer gameCount = setGameCount();
    setGame(carNames, gameCount);
    gameStart();
  }
  private void gameStart() {
    racingCarService.start();
  }
  private List<String> setCarNames() {
    return InputView.getCarNames();
  }

  private Integer setGameCount() {
    return InputView.getGameCount();
  }

  private void setGame(List<String> carNames, Integer gameCount) {
    List<Car> cars = setCars(carNames);
    racingCarService = new RacingCarService(cars, gameCount);
  }

  private List<Car> setCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for(String carName : carNames) {
      cars.add(new Car(carName, DISTANCE, MARK));
    }
    return cars;
  }


}