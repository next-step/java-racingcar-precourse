package util;

import java.util.Arrays;
import java.util.List;

public class Validator {

  public void checkCarNamesInput(String input) throws IllegalArgumentException {
    List<String> names = Arrays.asList(input.split(","));
    checkEmptyInput(input);
    checkEmptyName(names);
    checkNamelength(names);
  }

  private void checkEmptyInput(String input) throws IllegalArgumentException {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("입력 값이 비어있습니다. 다시 입력해 주세요");
    }
  }

  private void checkEmptyName(List<String> names) throws IllegalArgumentException {
    for (String name : names) {
      if (name.trim().isEmpty()) {
        throw new IllegalArgumentException("공백은 자동차 이름이 될 수 없습니다. 다시 입력해 주세요");
      }
    }
  }

  private void checkNamelength(List<String> names) throws IllegalArgumentException {
    for (String name : names) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    }
  }
}
