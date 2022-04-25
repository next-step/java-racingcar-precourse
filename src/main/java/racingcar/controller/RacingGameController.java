package racingcar.controller;

import racingcar.exception.UserInputException;
import racingcar.model.RacingInfo;
import racingcar.view.RacingGameUi;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameController {
    RacingInfo racingInfo;

    public void start(){
        racingInfo =  new RacingInfo();

        initUserInput();
        RacingGameUi.printRacingResultMsg();
        while(!racingInfo.isEnd()){
            racingInfo.racing();
        }

        RacingGameUi.printWinner(racingInfo.getHeadCarName());
    }

    private void initUserInput(){
        inputCarName();
        inputLabs();
    }

    private void inputCarName(){
        RacingGameUi.printNameInputMsg();

        try{
            racingInfo.setCarList(readLine());
        }catch(UserInputException e){
            inputCarName();
        }
    }

    private void inputLabs(){
        RacingGameUi.printLapsInputMsg();

        try{
            racingInfo.setLaps(readLine());
        }catch(UserInputException e){
            inputLabs();
        }
    }
}
