package racingcar.service;

import static racingcar.common.CommonVariable.OPENNING_REMARK_GAME_NUMBER_INPUT;
import static racingcar.common.CommonVariable.OPENNING_REMARK_RACING_CAR_NAME_INPUT;

import java.util.Scanner;
import racingcar.domain.CarManager;
import racingcar.domain.GameInput;
import racingcar.domain.GameOperator;

public class RacingGameExecutePlan {
    Scanner scanner;
    public RacingGameExecutePlan(){
        scanner = new Scanner(System.in);
    }

    public void gameExecutePlan(){
        GameInput carManager = new CarManager();
        gameInfoInput(carManager, OPENNING_REMARK_RACING_CAR_NAME_INPUT);
        GameInput gameOperator = new GameOperator();
        gameInfoInput(gameOperator, OPENNING_REMARK_GAME_NUMBER_INPUT);
        final RacingGameService racingGameService = new RacingGameService((CarManager)carManager, (GameOperator)gameOperator);
        racingGameService.runRacingGame();
        racingGameService.runGameResultPrint();
    }

    public void gameInfoInput(GameInput carManager, String remark){
        boolean isGameDataInput = false;
        System.out.println(remark);
        while (!isGameDataInput) {
            try {
                carManager.gameStartInput(scanner.next());
                isGameDataInput = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println(remark);
            }
        }
    }
}
