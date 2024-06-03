package View;

import Model.Car;
import Validator.Validator;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();

    public ArrayList<String> readCarName(){
        ArrayList<String> carNames = new ArrayList<>();
        while(true){
            carNames.clear();
            String input = scanner.nextLine();
            try{
                input = input.replace(", ", ",");
                for(String carName : input.split(",")){
                    validator.isCarNameValid(carName);
                    System.out.println(carName);
                    carNames.add(carName);
                }
                break;
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름이 잘못되었습니다.");
            }
        }
        return carNames;
    }

    public int readRound(){
        return scanner.nextInt();
    }
}
