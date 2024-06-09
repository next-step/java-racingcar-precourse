package View;

import Model.Car;

import java.util.ArrayList;

public class Validation {

    public ArrayList<Car> carNameException(){
        Input input = new Input();

        while(true){
            try {
                return input.getName();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] WRONG DATA INPUT!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int countException() {
        while(true){
            Input input = new Input();
            try {
                return input.getCount();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] WRONG DATA INPUT!");
            }
        }
    }
}
