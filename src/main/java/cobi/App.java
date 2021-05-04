package cobi;

import cobi.car.Racing;
import cobi.number.NumberGenerator;
import cobi.number.RandomNumberGenerator;
import cobi.view.ConsoleView;

public class App {
  /**
   * 레이싱 main
   */
  public static void main(String[] args) {
    ConsoleView view = new ConsoleView();
    NumberGenerator numberGenerator = new RandomNumberGenerator();

    Racing racing = new Racing(view, numberGenerator);
    racing.start();
  }
}
