package controller;

import dto.CarName;
import service.CarService;
import view.UserInputView;

import java.util.Scanner;

public class GameController {
    private final UserInputView view = new UserInputView();
    private final Scanner scanner = new Scanner(System.in);
    private final CarService carService = new CarService();

    public void runGame() {
        CarName carName = receiveCarName();
        carService.createCars(carName);


    }

    private CarName receiveCarName () {
        CarName carName;
        while(true) {
            try {
                view.printAlertCarName();
                carName = new CarName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carName;
    }


}
