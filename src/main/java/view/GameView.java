package view;

import java.util.Scanner;

public class GameView {

    public String[] inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String userInput = scanner.nextLine();

        return userInput.split(",");
    }
}
