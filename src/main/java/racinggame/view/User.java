package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Constant;
import racinggame.domain.CarsName;
import racinggame.domain.Chances;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;

public class User {
    public CarsName askCarsName() {
        CarsName carsName;
        do {
            System.out.println(Constant.ASK_INPUT_CARS_MSG);
            carsName = new CarsName(Console.readLine());
        } while (!carsName.isValidValue);
        return carsName;
    }

    public Chances askChances() {
        Chances chances;
        do {
            System.out.println(Constant.ASK_INPUT_CHANCE_MSG);
            chances = new Chances(Console.readLine());
        } while (!chances.isValidValue);
        return chances;
    }

    public void printRacingResultStartMsg() {
        System.out.println(Constant.OUTPUT_TITLE);
    }

    public void printRacingResult(RacingResult racingResult) {
        for (int i = 0; i < racingResult.result.size(); i++) {
            System.out.print(racingResult.result.get(i).getCarName());
            System.out.print(Constant.COLON);
            printDash(racingResult.result.get(i).getMoveCnt());
        }
        System.out.print(Constant.NEXT_LINE);
    }

    public void printDash(int moveCnt) {
        for (int i = 0; i < moveCnt; i++) {
            System.out.print(Constant.DASH);
        }
        System.out.print(Constant.NEXT_LINE);
    }

    public void printWinner(Winner winner) {
        System.out.print(Constant.PRINT_WINNER_FRONT);
        int commaCnt = winner.winner.size() - 1;
        for (String key : winner.winner.keySet()) {
            System.out.print(key);
            printComma(commaCnt);
            commaCnt--;
        }
        System.out.println(Constant.PRINT_WINNER_BACK);
    }

    public void printComma(int commaCnt) {
        if (commaCnt > 0) {
            System.out.print(Constant.COMMA);
        }
    }
}
