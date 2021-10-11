package racinggame;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.model.Car.Car;
import racinggame.model.Cars.Cars;
import racinggame.model.RacingRoundTotal;
import racinggame.model.Winner;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class CarRacingGame {
  public static final String ERROR_MSG = "[ERROR] %s";
  public static final String INPUT_CARNAME_REQ_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  public static final String INPUT_ROUND_REQ_MSG = "시도할 회수는 몇회인가요?";
  public static final int RANDOM_START = 0;
  public static final int RANDOM_END = 9;
  public static final int RANDOM_CHECKER = 3;
  private Predicate<Car> drivingStrategy;
  private RacingRoundTotal racingRoundTotal;
  private Cars cars;

  CarRacingGame() {
    drivingStrategy = getDefaultDrivingStrategy();
  }

  public CarRacingGame(RacingRoundTotal racingRoundTotal, Cars cars, Predicate<Car> drivingStrategy) {
    this.racingRoundTotal = racingRoundTotal;
    this.cars = cars;
    this.drivingStrategy = drivingStrategy;
  }

  private Predicate<Car> getDefaultDrivingStrategy() {
    return (car) -> Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) > RANDOM_CHECKER;
  }

  public void play() {
    userInputProcess();
    racing();
    resultPrint();
  }

  private void userInputProcess() {
    System.out.println(INPUT_CARNAME_REQ_MSG);
    getRepeatInput((s) -> {
      cars = new Cars(s);
    });
    System.out.println(INPUT_ROUND_REQ_MSG);
    getRepeatInput((s) -> {
      racingRoundTotal = new RacingRoundTotal(s);
    });
  }

  private void resultPrint() {
    Winner winner = new Winner(cars);
    System.out.println(winner.print());
  }

  private void racing() {
    for (int i = 0; i < racingRoundTotal.getRound(); i++) {
      System.out.println();
      cars.drive(drivingStrategy);
      System.out.println(cars.print());
    }
  }

  private void getRepeatInput(Consumer<String> throwableFunc) {
    do {
      try {
        String s = Console.readLine();
        throwableFunc.accept(s);
        return;
      }
      catch (IllegalArgumentException e) {
        System.out.println(String.format(ERROR_MSG, e.getMessage()));
      }
    } while (true);
  }
}
