package view;

import java.util.Scanner;

public class InputView {
    public static String InputCar(){
        String carname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the names of the cars you want to race. (The names are separated by commas (,).");
        carname = scanner.nextLine();
        return carname;
    }

    public static int InputNumber(){
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times to try?");
        number = scanner.nextInt();
        return number;
    }
}
