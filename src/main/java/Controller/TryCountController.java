package Controller;

import Service.TryCountService;
import View.Print;
import java.util.Scanner;

public class TryCountController {

    Print print = new Print();
    Scanner sc = new Scanner(System.in);
    TryCountService count = new TryCountService();

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
