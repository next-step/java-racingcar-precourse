package racinggame.enums;

public enum Errors {
  E00001("자동차 이름의 길이는 5이하여야 합니다.");

  private final String message;

  Errors(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public static void println(String message) {
    System.out.println("[ERROR] " + message);
  }
}
