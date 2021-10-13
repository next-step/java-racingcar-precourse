package racinggame.view;

import racinggame.domain.*;

public class OutputView {
    private static final String RESULT_MSG = "실행 결과";
    private static final String WINNER_START_MSG = "최종 우승자는";
    private static final String WINNER_END_MSG = "입니다.";

    public static void printResult(AllRaceStates allRaceStates, Winners winners) {
        System.out.println(RESULT_MSG);
        printAllRaceStates(allRaceStates);
        printWinnerNames(winners);
    }

    private static void printAllRaceStates(AllRaceStates allRaceStates) {
        for (RaceStates raceStates : allRaceStates.getAllRaceStates()) {
            printRaceStates(raceStates);
        }
    }

    private static void printRaceStates(RaceStates raceStates) {
        for (Car car : raceStates.getCars().getCars()) {
            System.out.println(car.getCarName().getName() + " : " + printCarMovement(car.getCarMovements()));
        }
        System.out.println();
    }

    private static String printCarMovement(CarMovement carMovement) {
        StringBuilder carMovementResult = new StringBuilder();
        for (MovementStatus movementStatus : carMovement.getCarMovements()) {
            carMovementResult.append(printMovementStatus(movementStatus));
        }
        return carMovementResult.toString();
    }

    private static String printMovementStatus(MovementStatus movementStatus) {
        if (movementStatus == MovementStatus.GO) {
            return "-";
        }
        return "";
    }

    private static void printWinnerNames(Winners winners) {
        System.out.printf("%s ", WINNER_START_MSG);
        StringBuilder tmpWinnerNames = new StringBuilder();
        for (Car car : winners.getWinners()) {
            tmpWinnerNames.append(","+car.getCarName().getName());
        }
        System.out.printf("%s ", tmpWinnerNames.substring(1));
        System.out.println(WINNER_END_MSG);
    }


}

