package view;

import java.util.Scanner;
import validation.Validation;

public class InputView {
    Scanner scan ;
    PrintView printView;
    Validation validation;
    public InputView(){
        scan = new Scanner(System.in);
        printView = new PrintView();
        validation = new Validation();
    }
    public String inputCarNames(){

        String input;
        while(true) {
            printView.printStartView();
            input = scan.nextLine();
            if(validation.inputNameCheck(input)) {
                break;
            }
        }
        return input;
    }

    public int inputCount(){

        String cnt;
        while(true) {
            printView.printCountView();
            cnt = scan.nextLine();

            if(validation.inputCountCheck(cnt)) {
                break;
            }
        }
        return Integer.parseInt(cnt);
    }
}
