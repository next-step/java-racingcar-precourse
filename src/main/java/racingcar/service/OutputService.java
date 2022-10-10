package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.value.OutputMessage;

public class OutputService {

    public static void printLine() {
        System.out.println();
    }

    public static void printInput(OutputMessage outputMessage) {
        System.out.println(outputMessage.getContent());
    }

    public static void printExecute() {
        printLine();
        System.out.println(OutputMessage.EXECUTE.getContent());
    }

    public static void printMove(Car car) {
        System.out.println(car.getName().getName() + " : " + printMoveMark(car.getMove().getDistance()));
    }

    public static void printWinner(Winners winners) {
        printLine();
        System.out.println(OutputMessage.WINNERS.getContent() + winners.toString());
    }

    public static void inputArgumentError(IllegalArgumentException e) {
        System.out.println(OutputMessage.ERROR.getContent() + e.getMessage());
    }

    private static String printMoveMark(int move) {
        StringBuilder mark = new StringBuilder();

        for (int count = 0; count < move; count++) {
            mark.append("-");
        }

        return mark.toString();
    }
}
