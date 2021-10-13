package racinggame.domain;

import nextstep.utils.Console;
import racinggame.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private RacingGame racingGame;
    private List<Car> cars;
    private int tryNo = 0;

    public void run() {
        inputCars();
        inputTryNo();

        racingGame = new RacingGame(cars, tryNo);

        while(racingGame.racing()) {
            racingGame.race();
            List<Car> cars = racingGame.getCars();
            printCars(cars);
            System.out.println("");
        }

        printWinners(racingGame.getCars());
    }

    private void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String names = Console.readLine();
        while (!ValidationUtils.validateCarsNames(names)
                || ValidationUtils.duplicateCarNames(names))
        {
            System.out.println(ERROR_MESSAGE);
            names = Console.readLine();
        }
        cars = RacingGame.initCars(names);
    }

    private void inputTryNo() {
        System.out.println("시도할 횟수는 몇회인가요?");

        String tryNo = Console.readLine();
        while(!ValidationUtils.validateTryNo(tryNo)) {
            System.out.println(ERROR_MESSAGE);
            tryNo = Console.readLine();
        }
        this.tryNo = Integer.parseInt(tryNo);
    }

    private void printCars(List<Car> cars) {
        for (Car car : cars) {
            String carStatus = String.format("%s : %s", car.getName(), changePositionToBar(car.getPosition()));
            System.out.println(carStatus);
        }
    }

    private String changePositionToBar(int position) {
        String result = "";
        for(int i = 0; i < position; i++)
            result += "-";
        return result;
    }

    private void printWinners(List<Car> cars) {
        System.out.println(String.format("최종 우승자는 %s 입니다.", findWinnersNames(cars, getMaxPosition(cars))));
    }

    private int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars)
            max = Math.max(max, car.getPosition());
        return max;
    }

    private String findWinnersNames(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition)
                winners.add(car.getName());
        }
        return String.join(",", winners);
    }
}
