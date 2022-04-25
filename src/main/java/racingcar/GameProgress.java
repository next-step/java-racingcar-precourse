package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameProgress {

    static CarNames carNames;
    static Cars cars;
    static TryCount tryCount;

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int RANDOM_STANDARD = 4;

    public static void gameStart() {
        boolean isCarNamesNotCorrectInput = true;
        while (isCarNamesNotCorrectInput) {
            isCarNamesNotCorrectInput = inputCarNames();
        }

        boolean isTryCountNotCorrectInput = true;
        while (isTryCountNotCorrectInput) {
            isTryCountNotCorrectInput = inputTryCount();
        }

    }

    private static boolean inputTryCount() {

        System.out.println("시도할 횟수는 몇회인가요?");

        try {
            tryCount = new TryCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }

        return false;
    }

    private static boolean makeCarName() {

        try {
            cars = new Cars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }

        return false;
    }

    private static boolean inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            carNames = new CarNames(Console.readLine());
            return makeCarName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }

    }

    public static void gamePlaying() {

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount.tryCount; i++) {
            carAction();
            System.out.println("");
        }

    }

    private static void carAction() {

        for (Car c : cars.cars) {
            c.goForward(isGoForward(c));
            c.showNowPosition();
        }
    }

    private static boolean isGoForward(Car c) {

        int random = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (random >= RANDOM_STANDARD) {
            return true;
        }

        return false;
    }

    public static void showGameResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자: ");
        stringBuilder.append(cars.whoIsWinner());
        System.out.println(stringBuilder.toString());
    }
}
