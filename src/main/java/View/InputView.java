package View;

import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<String> readCarName(){
        String input = scanner.nextLine();
        ArrayList<String> carNames = new ArrayList<>();
        for(String carName : input.split(",")){
            carNames.add(carName);
        }
        return carNames;
    }

    public int readRound(){
        return scanner.nextInt();
    }
}
