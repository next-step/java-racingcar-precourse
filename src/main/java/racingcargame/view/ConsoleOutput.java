package racingcargame.view;

public class ConsoleOutput {
    public static void printResult(String resultString) {
        System.out.println("실행 결과");
        System.out.println(resultString);
    }

    public static void printWinnerMessage(String winnerMessage) {
        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }
}
