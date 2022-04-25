package racingcar.view;

import java.util.ArrayList;

public class Output {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::print);
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.println("최종 우승자: "+String.join(",", winners));
    }

}
