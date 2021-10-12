package racinggame;

import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        CarController carController = new CarController();

        carView.startGame();
        carController.createCar(Console.readLine());
        carView.inputGameSize();
        carController.setGameCount(Console.readLine());
        carView.resultMsg();
        carController.carRaceStart();

    }
}
