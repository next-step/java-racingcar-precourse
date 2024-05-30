package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import model.Car;
import view.Print;

public class Run {

    private static Validation validation = new Validation();

    private List<Car> carNamesInput() {
        List<Car> cars = null;
        while (true) {
            try {
                Print.printCarNameInputComment();
                String[] carsNames = Input.CarNameInput();
                validation.validationCarName(carsNames);
                cars = Arrays.stream(carsNames).map(carName -> new Car(carName, 0)).toList();
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }
}
