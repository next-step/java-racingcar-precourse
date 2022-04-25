package racingcar.view;

public class OutputView {

    private static final String WINNER_SENTENCE = "최종 우승자: " ;
    private static final String HEADLINE = "실행 결과" ;

    private static void printHeadLine() {
        System.out.println(HEADLINE);
    }

    private static void printScores(String scores) {
        System.out.println(scores);
    }

    private static void printWinner(String winners) {
        System.out.println(WINNER_SENTENCE + winners);
    }

    public static void resultPrintOut(String scores, String winners) {
        printHeadLine();
        printScores(scores);
        printWinner(winners);
    }
}
