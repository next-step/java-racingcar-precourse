package racinggame.view;

import nextstep.utils.Console;
import racinggame.utils.Message;
import racinggame.utils.CarsName;
import racinggame.utils.Chances;
import racinggame.utils.Result;
import racinggame.utils.Winner;

public class User {
    public CarsName askCarsName() {
        CarsName carsName;
        do {
            System.out.println(Message.ASK_INPUT_CARS_MSG);
            carsName = new CarsName(Console.readLine());
        } while (!carsName.isValidValue);
        return carsName;
    }

    public Chances askChances() {
        Chances chances;
        do {
            System.out.println(Message.ASK_INPUT_CHANCE_MSG);
            chances = new Chances(Console.readLine());
        } while (!chances.isValidValue);
        return chances;
    }

    public void printResult(Result result) {
        for (int i = 0; i < result.result.size(); i++) {
            System.out.print(result.result.get(i).getCarName());
            System.out.print(" : ");
            printDash(result.result.get(i).getMoveCnt());
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public void printDash(int moveCnt) {
        for(int i = 0; i < moveCnt; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(Winner winner) {
        System.out.print("최종 우승자는 ");
        for (int key : winner.winner.keySet()) {
            System.out.print(winner.winner.get(key));
        }
        System.out.println(" 입니다.");
    }
}
