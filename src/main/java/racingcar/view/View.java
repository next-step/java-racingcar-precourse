package racingcar.view;

public class View {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String PLAY_RESULT = "실행 결과";
    private static final String WINNER_SUBTITLE = "최종 우승자: ";

    public static void printSubtitle(String subtitle) {
        System.out.print(subtitle);
    }

    public static void printSubtitleln(String subtitle) {
        System.out.println(subtitle);
    }

    public static void printInputCarNames(){
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printInputCount(){
        System.out.println(INPUT_COUNT);
    }

    public static void printPlay(){
        System.out.println(PLAY_RESULT);
    }

    public static void printWinners(String message){
        System.out.println(WINNER_SUBTITLE + message);
    }
}
