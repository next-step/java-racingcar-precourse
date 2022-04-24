package racingcar.domain;

import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Game {
    private final RacingCars racingCars;

    public Game(){
        racingCars = new RacingCars();
    }
    public void runGame() {
        try{
            List<Car> racingCarList = racingCars.makeCars(Input.inputCarNames());
            int counterInput = Input.inputCounter();
            GameRule gameRule = new GameRule(racingCars);
            String result = gameRule.logicOfRule(racingCarList, counterInput);
            Output.resultMessage(result);
        }catch(IllegalArgumentException e){
            Output.outputMessage(e.getMessage());
            runGame();
        }
    }
}