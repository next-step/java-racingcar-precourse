package view;

import java.util.List;
import java.util.Scanner;
import util.CarNamesParser;

public class GameView {
    Scanner scanner = new Scanner(System.in);
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        List<String> carNames = CarNamesParser.parse(input);
        return carNames;
    }

}
