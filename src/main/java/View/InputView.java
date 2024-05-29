package View;

import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    String readCarName(){
        return scanner.nextLine();
    }

    int readRound(){
        return scanner.nextInt();
    }
}
