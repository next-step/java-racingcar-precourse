package controller;

import java.io.IOException;
import java.util.List;
import model.Car;
import view.Print;

public class Run {

    private Validation validation = new Validation();
    private Service service = new Service();

    private List<Car> carNamesInput() {
        while (true) {
            try {
                Print.printCarNameInputComment();
                List<String> carsNames = Input.carNameInput();
                validation.validationCarName(carsNames);
                return carsNames.stream().map(carName -> new Car(carName)).toList();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer tryCountInput() {
        while (true) {
            try {
                Print.printTryCountInputComment();
                String tryCount = Input.tryCountInput();
                validation.validationTryCount(tryCount);
                System.out.println();
                return Integer.parseInt(tryCount);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        List<Car> cars = carNamesInput();
        Integer tryCount = tryCountInput();

        Print.printExecutionResult();
        for (int i = 0; i < tryCount; i++) {
            service.moveCars(cars, service.generatePercent(cars.size()));
            Print.printTotalCarMovement(cars);
        }
        Print.printWinner(service.getWinner(cars));
    }
}
