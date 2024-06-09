package controller;

import domain.RacingCar;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(){
        this.racingCarService = new RacingCarService();
    }

    public void startRace(){
        OutputView.printRacingCarNameInputText();
        racingCarService.save(receiveRacingCarList());
        OutputView.printRoundNumberInputText();
        int roundNum = receiveRoundNumber();
        OutputView.printLine();

        startRound(roundNum);

        OutputView.printWinners(racingCarService.getWinners());
    }

    private void startRound(int roundNum){
        OutputView.printGameStart();
        for(int round=0; round<roundNum; round++){
            racingCarService.playRound();
            OutputView.printGameProgress(racingCarService.getRacingCarList());
        }
    }

    private List<RacingCar> receiveRacingCarList(){
        while(true){
            try{
                return InputView.inputCarNames();
            }catch (IllegalArgumentException exception){
                OutputView.printErrorMessage(exception);
            }
        }
    }

    private int receiveRoundNumber(){
        while(true){
            try{
                return InputView.inputRoundNumber();
            }catch (IllegalArgumentException exception){
                OutputView.printErrorMessage(exception);
            }
        }
    }
}
