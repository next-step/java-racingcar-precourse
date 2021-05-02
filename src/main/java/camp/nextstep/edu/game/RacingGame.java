package camp.nextstep.edu.game;

import camp.nextstep.edu.collection.RacingCarList;
import camp.nextstep.edu.constant.Message;
import camp.nextstep.edu.util.NumberUtil;
import camp.nextstep.edu.wrapper.RacingGameAttempts;

import java.util.Scanner;

public class RacingGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_NUMBER_BOUND = 10;
    private RacingCarList racingCarList;
    private RacingGameAttempts racingGameAttempts;

    @Override
    public void start() {
        System.out.println(Message.INPUT_CAR_NAME);
        String[] names = scanner.nextLine().split(",");
        racingCarList = new RacingCarList(names);

        System.out.println(Message.INPUT_NUMBER_OF_ATTEMPTS);
        racingGameAttempts = new RacingGameAttempts(scanner.nextLine());

        System.out.println(Message.EXECUTION_RESULT);
        RacingGameResult gameResult = play();
        System.out.println(gameResult);
    }

    private RacingGameResult play() {
        for (int i = 0; i < racingGameAttempts.getAttempts(); i++) {
            racing();
            System.out.println();
        }
        return new RacingGameResult(racingCarList.getCarList());
    }

    private void racing() {
        for (RacingCar racingCar : racingCarList.getCarList()) {
            int generatedNumber = NumberUtil.generateNumber(MAX_NUMBER_BOUND);
            racingCar.move(generatedNumber);
            System.out.println(racingCar);
        }
    }
}
