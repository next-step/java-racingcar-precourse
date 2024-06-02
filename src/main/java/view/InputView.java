package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String carsNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return userInputProcessing();
    }

    public String tryNumberInput(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return userInputProcessing();
    }

    private String userInputProcessing() {
        return scanner.nextLine();
    }

}
