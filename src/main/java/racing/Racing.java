package racing;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class Racing {

  private InputView inputView;
  private ResultView resultView;

  public Racing() {
    this.inputView = new InputView();
    this.resultView = new ResultView();
  }

  public void run() {
    String[] carNames = inputView.getCarNames();
    Cars cars = createCars(carNames);
    int tryCount = inputView.getTryCount();
    moves(cars, tryCount);
  }

  private void moves(Cars cars, int tryCount) {
    for (int i = 0; i < tryCount; i++) {
      cars = cars.moveByStrategy();
      resultView.print(cars.getNames(), cars.result());
      System.out.println();
    }
  }

  private Cars createCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return new Cars(cars);
  }

}
