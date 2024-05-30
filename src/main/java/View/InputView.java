package View;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);
    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하시요.(이름은 쉼표(,) 기준으로 구분)");

        return sc.nextLine();
    }
    public int inputCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextInt();
    }

    public void printError(String message){
        System.out.println("[ERROR]"+message);
    }
}
