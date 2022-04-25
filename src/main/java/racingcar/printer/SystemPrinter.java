package racingcar.printer;

public class SystemPrinter extends Printer {

  @Override
  public void print(final String message) {
    System.out.print(message);
  }
}
