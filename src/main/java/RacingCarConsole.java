import resulttypes.PlayResult;

import java.util.Scanner;

public class RacingCarConsole {

    private static final String WELCOME_MSG = "레이싱 카 게임에 오신 걸 환영합니다!!";
    private static final String REQUEST_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRIAL_COUNT_MSG = "시도할 횟수는 몇회인가요?";
    private static final String ABNORMAL_TERMINATE_MSG = "비정상적인 입력으로 인해 프로그램을 종료합니다.";

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String carNamesInput = askCarNamesInput(scanner);
        String trialCntInput = askTrialCntInput(scanner);

        RacingCarGame game = new RacingCarGame();

        if (game.play(carNamesInput, trialCntInput) == PlayResult.INVALID_INPUT) {
            System.out.println(ABNORMAL_TERMINATE_MSG);
        }
    }

    private static String askCarNamesInput(Scanner scanner) {
        System.out.println(WELCOME_MSG);
        System.out.println(REQUEST_CAR_NAME_MSG);

        return scanner.nextLine();
    }

    private static String askTrialCntInput(Scanner scanner) {
        System.out.println(REQUEST_TRIAL_COUNT_MSG);

        return scanner.nextLine();
    }
}
