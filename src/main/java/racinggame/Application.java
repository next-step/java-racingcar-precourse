package racinggame;

import nextstep.utils.Console;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args){
        CarView carView = new CarView();
        CarController carController = new CarController();

        carView.startGame();
        carController.createCar(inputCheck(Console.readLine()));
        carView.inputGameSize();
        carController.setGameCount(inputCheck(Console.readLine()));
        carView.resultMsg();
        carController.carRaceStart();
        carView.winnerMsg(carController.raceResult());

    }

    public static String inputCheck(String inputData){
        try{
            return whileInput(inputData);
        }catch(NoSuchElementException e){
            System.out.println("[ERROR]");
        }finally {
            return whileInput(inputData);
        }
    }

    public static String whileInput(String inputData){
        while (inputData.length() == 0) {
            Console.readLine();
        }
        return inputData;
    }

}
