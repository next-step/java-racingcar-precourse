package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.utils.InputValidation;

public class Application {
    public static String inputValueLine;
    public static int inputTryNumber;
    public static int errorNumber = 0;
    public static void main(String[] args) {
        inputCarName();
        inputTryNumber();
        playRacingGame();
    }

    public static void inputCarName() {
        try {
            System.out.println("경주 할 자동차 이름");
            inputValueLine = Console.readLine();
            InputValidation.parseInputValueCar(inputValueLine);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + ++errorNumber + "회");
            inputCarName();
        }
    }

    public static void inputTryNumber() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String inputString = Console.readLine();
            InputValidation.intValueChecking(inputString);
            inputTryNumber = Integer.parseInt(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + ++errorNumber + "회");
            inputTryNumber();
        }
    }

    public static void playRacingGame() {
        RacingGame racingGame = new RacingGame(inputValueLine);
        System.out.println("실행 결과\n");
        for(int i = 0; i < inputTryNumber; i++) {
            System.out.println(racingGame.progressOneStep());
        }
        System.out.println(racingGame.printCurrentWinner());
    }

}
