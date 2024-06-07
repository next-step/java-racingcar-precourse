package view;

import controller.GameController;

import java.util.Map;

public class OutputView {
    public static void printGame(GameController gameController) {
        int gameIteration = gameController.getGameIteration();
        for (int i = 0; i < gameIteration; i++) {
            Map<String, Integer> gameRecords = gameController.recordsCarMovements();
            printNameAndMovements(gameRecords);
        }
        System.out.println("최종 우승자 : " + gameController.getWinner());
    }

    private static void printNameAndMovements(Map<String, Integer> gameRecords) {
        for (String name : gameRecords.keySet()) {
            System.out.print(name + " : ");
            printDash(name, gameRecords);
        }
        System.out.println();
    }

    private static void printDash(String name, Map<String, Integer> gameRecords) {
        int dashNumber = gameRecords.get(name);
        for (int j = 0; j < dashNumber; j++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
