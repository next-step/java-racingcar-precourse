import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetCarNames {
    public static List<String> getCarNames(Scanner scanner) {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = scanner.nextLine();
                String[] names = input.split(",");
                List<String> carNames = new ArrayList<>();
                for (String name : names) {
                    carNames.add(name.trim());
                }
                CheckCarNames.checkCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
