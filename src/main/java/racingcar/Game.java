package racingcar;

import java.util.Iterator;
import java.util.Scanner;

public class Game {
    private static final String REQUIRE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_ROUND_NUMS = "시도할 회수는 몇회인가요?";
    private static final String PLAY_RESULT = "실행 결과";
    private static final String PRESENT_WINNER = "가 최종 우승했습니다.";

    private static Scanner scanner;
    private Cars cars;
    private int round;

    private void requireRounds() {
        System.out.println(REQUIRE_ROUND_NUMS);
        round = scanner.nextInt();
    }

    private String[] askCars() {
        System.out.println(REQUIRE_NAMES);
        String input = scanner.nextLine();
        return input.split(",");
    }

    private void addCars() {
        String[] inputNames = askCars();
        cars.addCars(inputNames);
    }

    private void requireCars() {
        while (!ValidationUtils.isPlayable(cars)) {
            addCars();
        }
    }

    private void decideWinners() {
        Iterator<Car> iterator = cars.getWinners().iterator();
        Car next = iterator.next();
        System.out.print(next);

        while (iterator.hasNext()) {
            next = iterator.next();
            System.out.print(", " + next);
        }

        System.out.println(PRESENT_WINNER);
    }

    public void play() {
        requireCars();
        requireRounds();

        System.out.println(PLAY_RESULT);

        for (int i = 0; i < round; i++) {
            cars.playRound();
            System.out.println();
        }

        decideWinners();
    }

    public Game() {
        scanner = new Scanner(System.in);
        cars = new Cars();
    }
}
