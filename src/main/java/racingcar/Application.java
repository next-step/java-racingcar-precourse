package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RaceController rc = new RaceController();
        String notice = rc.init();
        System.out.println(notice);
        notice = inputCarNamesUntilNoError(rc, notice);
        inputTurnUntilNoError(rc, notice);
        System.out.println(rc.play());
    }

    private static String inputCarNamesUntilNoError(RaceController rc, String notice) {
        String result = rc.inputCarNames(Console.readLine());
        System.out.println(result);
        while(result.contains("[ERROR]")) {
            System.out.println(notice);
            result = rc.inputCarNames(Console.readLine());
            System.out.println(result);
        }
        return result;
    }

    private static void inputTurnUntilNoError(RaceController rc, String notice) {
        String result = rc.inputTurn(Console.readLine());
        System.out.println(result);
        while(result.contains("[ERROR]")) {
            System.out.println(notice);
            result = rc.inputTurn(Console.readLine());
            System.out.println(result);
        }
    }
}
