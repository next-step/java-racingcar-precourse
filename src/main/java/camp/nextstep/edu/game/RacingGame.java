package camp.nextstep.edu.game;

import camp.nextstep.edu.constant.Message;
import camp.nextstep.edu.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_NUMBER_BOUND = 10;
    private final List<RacingCar> racingCarList = new ArrayList<>();
    private int attempts;

    @Override
    public void start() {
        System.out.println(Message.INPUT_CAR_NAME);
        String[] names = scanner.nextLine().split(",");
        setRacingCarList(names);
        System.out.println(Message.INPUT_NUMBER_OF_ATTEMPTS);
        setAttempts(scanner.nextLine());
        int generatedNumber = NumberUtil.generateNumber(MAX_NUMBER_BOUND);
    }

    private void setRacingCarList(String[] names) {
        for (String name : names) {
            racingCarList.add(new RacingCar(name));
        }
    }

    private void setAttempts(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number <= 0) {
                throw new IllegalArgumentException(Message.INVALID_NUMBER_OF_ATTEMPTS);
            }
            this.attempts = number;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
