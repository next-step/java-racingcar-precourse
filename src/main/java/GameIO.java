
import java.util.Scanner;

public class GameIO {

    Scanner sc;
    final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String INPUT_TRY_NUMBER = "시도할 횟수는 몇회인가요?";
    final String SHOW_RESULT = "\n실행 결과";
    final String PRINT_WINNER = "가 최종 우승했습니다.";

    public GameIO() {
        sc = new Scanner(System.in);
    }

    public void printInputName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public void printInputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER);
    }

    public void showResult() {
        System.out.println(SHOW_RESULT);
    }

    public void printWinner(String winners) {
        System.out.println(winners + PRINT_WINNER);
    }

    public void printResult(String str) {
        showResult();
        System.out.println(str);
    }

    public String inputFromUser() {
        String input = sc.next();
        return input;
    }

}
