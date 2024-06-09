package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    //자동차 이름을 입력 받고 반환
    public String[] getCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        return input.split(",");
    }

    //이동횟수를 입력 받고 반환
    public String getCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.next();
    }
}
