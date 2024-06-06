package view;

import controller.GameController;
import model.GameDTO;

import java.util.Map;

public class OutputView {
    public static void printResult(GameController gameController) {
        int gameIteration = gameController.getGameIteration();
        for (int i = 0; i < gameIteration; i++) {
            Map<String, Integer> gameRecords = gameController.recordsCarMovements();
            for (String name : gameRecords.keySet()) {
                System.out.print(name + " : ");
                printDash(name, gameRecords);
            }
            System.out.println();
        }
        System.out.println("최종 우승자 : " + gameController.getWinner());
    }

    private static void printDash(String name, Map<String, Integer> gameRecords) {
        int dashNumber = gameRecords.get(name);
        for (int j = 0; j < dashNumber; j++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
