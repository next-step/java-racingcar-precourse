package racingcar.view;

public final class RacingCarViewer {

    private RacingCarViewer() {}

    public static void printFirstQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printSecondQuestion() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행결과");
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printCarStatus(String name, String distance) {
        System.out.printf("%s : %s%n", name, distance);
    }
}
