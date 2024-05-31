package Controller;

import Service.TryCountService;
import View.Print;
import java.util.Scanner;

public class TryCountController {

    Print print = new Print();
    Scanner sc = new Scanner(System.in);
    TryCountService count = new TryCountService();

//    시도 횟수를 입력 받는다.
//    문자열로 입력된 정수를 검증 후 int 정수로 반환한다.
//    숫자 외 입력시 IllegalArgumentException를 반환한다.
//    int범위를 넘어선 값에 대해서는 IllegalStateException를 반환한다.
    public int getTryCount() {
        while (true) {
            try {
                print.print("시도할 회수는 몇회인가요?");
                String num = sc.nextLine();

                return count.isNumber(num);

            } catch (IllegalArgumentException e) {
                print.printError("IllegalArgumentException");
            } catch (IllegalStateException e) {
                print.printError("IllegalStateException");
            }
        }
    }
}
