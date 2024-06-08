import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInputView {


    public List<String> inputCarNameList() {
        Scanner scanner = new Scanner(System.in);
        List<String> carNameList = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        scanner.close();

        for (String car : carNames) {
            carNameList.add(car.trim());
        }

        return carNameList;
    }
}
