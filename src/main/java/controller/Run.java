package controller;

import java.util.List;
import model.Car;
import view.Print;

public class Run {

    private Validation validation = new Validation();
    private Service service = new Service();
    private Print print = Print.getInstance();

    private List<Car> carNamesInput() {
        List<String> carsNames = null;
        boolean flag = true;
        while (flag) {
            print.printCarNameInputComment();
            carsNames = Input.carNameInput();
            flag = !validation.validationCarName(carsNames);
        }
        return carsNames.stream().map(carName -> new Car(carName)).toList();
    }

    private Integer tryCountInput() {
        String tryCount = null;
        boolean flag = true;
        while (flag) {
            print.printTryCountInputComment();
            tryCount = Input.tryCountInput();
            flag = !validation.validationTryCount(tryCount);
        }
        System.out.println();
        return Integer.parseInt(tryCount);
    }

    public void run() {
        List<Car> cars = carNamesInput();
        Integer tryCount = tryCountInput();

        print.printExecutionResult();
        for (int i = 0; i < tryCount; i++) {
            service.moveCars(cars, service.generatePercent(cars.size()));
            print.printTotalCarMovement(cars);
        }
        print.printWinner(service.getWinner(cars));
    }
}
