package racingcar.service;

import static racingcar.common.CommonVariable.EXECUTE_RESULT;

import java.util.Arrays;
import java.util.Map;
import racingcar.domain.CarManager;
import racingcar.domain.GameOperator;
import racingcar.domain.RacingCar;

public class RacingGameService {
    private CarManager carManager;
    private GameOperator gameOperator;

    public RacingGameService(CarManager carManager, GameOperator gameOperator){
        this.carManager = carManager;
        this.gameOperator = gameOperator;
    }

    public void runRacingGame(){
        System.out.println(EXECUTE_RESULT);
        while(!gameOperator.isTurnEnd()){
            final Map<String, RacingCar> joinRacingCarsMap = carManager.getJoinRacingCarsMap();
            Arrays.asList(carManager.getRacingJoinCarNames()).forEach(racingCarName -> {
                RacingCar racingCar = joinRacingCarsMap.get(racingCarName);
                racingCar.runRacing();
                System.out.println(racingCarName + " : " + racingCar.showGoToDistance());
            });
            gameOperator.runTurn();
            System.out.println();
        }
    }

    public void runGameResultPrint(){
        carManager.racingGameWinnerPrint();
    }
}
