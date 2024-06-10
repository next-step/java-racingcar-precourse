package controller;

import controller.res.CarInfoDto;
import domain.state.CarState;
import java.util.List;
import java.util.stream.Collectors;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }
    public void carInit(){
        while(true){
            try{
                var carName = InputView.readCarName();
                racingGameService.trackInit(carName);
                break;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }

    }

    public int gameCountInit(){
        while(true){
            try{
                return InputView.readGameCount();
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
    public void runGame(){
        var gameCount = gameCountInit();

        OutputView.printResultOutput();
        for(int i = 0; i < gameCount; i++){
            racingGameService.runStep();
            var cars = racingGameService.getCars();
            OutputView.printStep(cars.stream().map(CarInfoDto::toDTO).toList());
        }

        OutputView.printResult(racingGameService.getWinners().stream().map(CarInfoDto::toDTO).toList());
    }
}
