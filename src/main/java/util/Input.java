package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import view.InputView;

public class Input {
  private final InputView inputView = new InputView();
  private final Validator validator = new Validator();

  private Scanner sc = new Scanner(System.in);
  public List<String> getCarNames(){
    while(true){
      try{
        inputView.requestCarNameMessage();
        String input = sc.nextLine();
        validator.checkCarNamesInput(input);
        return new ArrayList<>(Arrays.asList(input.split(",")));
      } catch(IllegalArgumentException e){
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  public Integer getNumberOfAttempts(){
    while(true) {
      try {
        inputView.requestNumberOfAttempsMessage();
        return sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }
}
