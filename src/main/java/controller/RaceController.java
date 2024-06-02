package controller;

import model.Car;
import model.RaceCars;
import utils.RandomNumberGenerator;
import view.OutputView;

public class RaceController {
    private final InputController inputController;
    private final OutputView outputView;
    private final RaceCars raceCars;

    public RaceController() {
        inputController = new InputController();
        outputView = new OutputView();
        raceCars = new RaceCars();
    }

    public void run(){
        int tryNum = userInputPreProcessing();

        startRace(tryNum);

        winner();
    }

    private int userInputPreProcessing() {
        raceCars.addCars(inputController.processingUserInputCarsName());
        int tryNum = inputController.processingUserInputTryNumber();
        return tryNum;
    }

    private void startRace(int tryNum){
        for(int i = 0; i < tryNum; i++){
            carAdvance();
            outputView.printGameInfo(raceCars.getCars());
        }
    }

    private void carAdvance(){
        for (Car car : raceCars.getCars()) {
            car.advance(RandomNumberGenerator.generator());
        }
    }

    private void winner() {
        outputView.printWinner(raceCars.getWinners());
    }

}
