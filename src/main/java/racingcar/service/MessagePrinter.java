package racingcar.service;

public class MessagePrinter {

    public static void printRequestCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestTryCountInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printMoveResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinnersMessage(final String winners) {
        System.out.println("최종 우승자: " + winners);
    }

}
