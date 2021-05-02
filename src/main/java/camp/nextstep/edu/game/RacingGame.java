package camp.nextstep.edu.game;

import camp.nextstep.edu.constant.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);
    private final List<RacingCar> racingCarList = new ArrayList<>();

    @Override
    public void start() {
        System.out.println(Message.INPUT_CAR_NAME);
        String[] names = scanner.nextLine().split(",");

        for (String name : names) {
            racingCarList.add(new RacingCar(name));
        }
    }
}
