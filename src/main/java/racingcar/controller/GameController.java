package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.view.ErrorView;
import racingcar.view.GameView;

public class GameController {

    GameView gameView = new GameView();
    Cars cars;

    public void GameStart(){
           CarNameInputStep();
           TryInputStep();
           GameEnd();
    }

    public void CarNameInputStep(){
        try {
            gameView.CarNameInputGuideMsg();
            cars = new Cars(Console.readLine());
        }catch (IllegalArgumentException e){
            ErrorView.printErrorMsg(e.getMessage());
            CarNameInputStep();
        }
    }

    public void TryInputStep(){
        try {
            gameView.TryInputGuideMsg();
            int value = Integer.parseInt(Console.readLine());
            TryStep(cars,value);
        }catch (IllegalArgumentException e){
            ErrorView.printErrorMsg("정수의 숫자를 입력해주세요.");
            TryInputStep();
        }

    }

    private void TryStep(Cars cars, int value) {
        gameView.StartCurrentDistance();
        for(int i = 0; i < value; i++){
            cars.CarsNextStep();
            gameView.printCurrentDistance(cars);
        }
    }

    public void GameEnd(){
        gameView.printCarWinner(cars);
    }
}
