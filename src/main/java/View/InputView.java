package View;

import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String readCarName(){
        return scanner.nextLine();
    }

    public int readRound(){
        return scanner.nextInt();
    }
}
