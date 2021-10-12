package racinggame.dto;

import nextstep.utils.Console;

public class GameView {

    public static String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String enterAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRaceResult(String raceResult) {
        System.out.println(raceResult);
    }

    public static void printGameResult(String winners) {
        System.out.println("최종 우승자는 " + winners + " 입니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
