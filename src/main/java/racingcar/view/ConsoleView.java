package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Strings;
import racingcar.domain.*;

import java.util.function.Supplier;

public class ConsoleView {
    public void render() {
        Cars cars = process(this::cars);
        ControlTower controlTower = new ControlTower(cars);
        Rounds rounds = process(this::rounds);

        System.out.println();
        System.out.println("실행 결과");
        repeatPerRound(cars, controlTower, rounds);

        System.out.println("최종 우승자: " + Strings.join(controlTower.getWinners()).with(", "));
    }

    private void repeatPerRound(Cars cars, ControlTower controlTower, Rounds rounds) {
        rounds.iterate(() -> {
            cars.driveAll();
            for (Car car : controlTower.getAll()) {
                System.out.println(car + " : " + controlTower.getPosition(car));
            }
            System.out.println();
        });
    }

    private Cars cars() {
        return consoleExceptionHandler(() -> {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();

            Cars cars = new Cars();
            for (String carName : carNames.split(","))
                cars.add(new Car(new CarName(carName)));

            return cars;
        });
    }

    private Rounds rounds() {
        return consoleExceptionHandler(() -> {
            System.out.println("시도할 회수는 몇회인가요?");
            return new Rounds(Console.readLine());
        });
    }

    private <T> T process(Supplier<T> supplier) {
        T t;
        do {
            t = supplier.get();
        } while (t == null);
        return t;
    }

    private <T> T consoleExceptionHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return null;
        }
    }
}
