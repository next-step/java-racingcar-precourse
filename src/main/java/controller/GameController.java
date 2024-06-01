package controller;

import dto.CarName;
import dto.MoveCount;
import service.CarService;
import view.ResultView;
import view.UserInputView;

import java.util.Scanner;

public class GameController {
    private final UserInputView userInputView = new UserInputView();
    private final ResultView resultView = new ResultView();
    private final Scanner scanner = new Scanner(System.in);
    private final CarService carService = new CarService();

    public void runGame() {
        CarName carName = receiveCarName();
        carService.createCars(carName);


        MoveCount moveCount = receiveMoveCount();
        resultView.printResultMessage();

        for(int i = 0; i < moveCount.count(); i++){
            carService.moveCars();
            resultView.printCars(carService.getCars());
        }

        resultView.printWinner(carService.getWinnerName());
    }

    private MoveCount receiveMoveCount() {
        MoveCount moveCount;
        while(true) {
            try {
                userInputView.printAlertMoveCount();
                moveCount = new MoveCount(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveCount;
    }

    private CarName receiveCarName () {
        CarName carName;
        while(true) {
            try {
                userInputView.printAlertCarName();
                carName = new CarName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carName;
    }


}
