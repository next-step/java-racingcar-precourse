package Views;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static String requestName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.next();
    }

    public static String requestTime(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.next();
    }
}
