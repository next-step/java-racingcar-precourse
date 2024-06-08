import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInputView {

    private boolean validatorInputCarNameList(String[] carNames) {
        for (String car : carNames) {
            if (car.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public List<String> inputCarNameList() {
        Scanner scanner = new Scanner(System.in);
        List<String> carNameList = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");

        boolean isValidCarNames = validatorInputCarNameList(carNames);

        while (!isValidCarNames) {
            System.out.println("자동차 이름을 쉼표로 구분해주시고, 각 이름의 길이는 5자 이하로 작성해주세요.");
            carNames = scanner.nextLine().split(",");
            isValidCarNames = validatorInputCarNameList(carNames);
        }

        scanner.close();

        for (String car : carNames) {
            carNameList.add(car.trim());
        }

        return carNameList;
    }
}
