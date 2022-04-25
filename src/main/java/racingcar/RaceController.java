package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceController {
    public static void run() {
        Cars racingCars = null;
        while (racingCars == null) {
            racingCars = getRacingCarsOrNull();
        }

        Counter counter = null;
        while (counter == null) {
            counter = getCounterOrNull();
        }

        final RaceModel raceModel = new RaceModel(racingCars, counter, new NextStepRandomNumberGenerator());

        printRace(raceModel);
        printWinners(raceModel.getWinners());
    }

    private static void printErrorMessage(final String message) {
        System.out.printf("[ERROR] %s%n", message);
    }

    private static void printRace(final RaceModel raceModel) {
        System.out.println("실행 결과");
        while (!raceModel.isFinished()) {
            Cars cars = raceModel.nextRace();
            printCars(cars);
        }
    }

    private static void printWinners(final Cars winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners.asList()) {
            winnerNames.add(car.getName().toString());
        }
        System.out.printf("최종 우승자: %s%n", String.join(", ", winnerNames).trim());
    }

    private static void printCars(final Cars cars) {
        for (Car car : cars.asList()) {
            System.out.println(car);
        }
        System.out.println();
    }

    private static Cars getRacingCarsOrNull() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String commaSeparatedCarNames = readLine();
            return parseCars(commaSeparatedCarNames);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return null;
        }
    }

    private static Cars parseCars(final String commaSeparatedCarNames) {
        String[] carNames = commaSeparatedCarNames.split(",");
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        return new Cars(cars);
    }

    private static Counter getCounterOrNull() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String count = readLine();
            return new Counter(Integer.parseInt(count));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return null;
        }
    }
}
