package racinggame.model;

import nextstep.utils.Console;

import java.util.function.Consumer;

public class InputUtil {
  public static final String ERROR_MSG = "[ERROR] %s";

  public static void getRepeatInput(Consumer<String> throwableFunc) {
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
