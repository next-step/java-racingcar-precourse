package view;

import controller.ValidateInput;
import java.util.Arrays;
import java.util.Scanner;
import model.CarsDTO;
import util.CarUtility;

public class InputView {

  private final Scanner scanner;
  private final ValidateInput validateInput;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
    validateInput = new ValidateInput();
  }

  public void InputInit() {
    CarInput();
  }

  public void CarInput() {
    String[] carNames;
    boolean carInputState;
    CarUtility carUtility = new CarUtility();
    do {
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      carNames = carUtility.carNamesSplit(scanner.nextLine());
      carInputState = validateInput.carNamesValidate(carNames);
    } while (!carInputState);
    CarsDTO carsDTO = new CarsDTO(carNames);
  }
}
