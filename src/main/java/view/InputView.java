package view;

import controller.ValidateInput;
import java.util.Scanner;
import model.CarDTO;
import model.GameStatusDTO;
import util.CarUtility;

public class InputView {

  private final Scanner scanner;
  private final ValidateInput validateInput;
  private final CarUtility carUtility;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
    validateInput = new ValidateInput();
    carUtility = new CarUtility();
  }

  public void InputInit() {
    CarInput();
    PlayCountInput();
  }

  public void CarInput() {
    String[] carNames;
    boolean carInputState;
    do {
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      carNames = carUtility.carNamesSplit(scanner.nextLine());
      carInputState = validateInput.carNamesValidate(carNames);
    } while (!carInputState);
    for (String carName : carNames) {
      CarDTO car = new CarDTO(carName);
      GameStatusDTO.cars.add(car);
    }
  }

  public void PlayCountInput() {
    String playCount;
    boolean playCountInputState;
    do {
      System.out.println("시도할 회수는 몇 회인가요?");
      playCount = scanner.nextLine();
      playCountInputState = validateInput.playCountValidate(playCount);
    } while (!playCountInputState);
    GameStatusDTO.playCount = Integer.parseInt(playCount);
  }
}
