package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.car.CarGroup;
import racingcar.result.RacingReferee;
import racingcar.result.RacingResult;
import racingcar.rule.Condition;
import racingcar.rule.ConditionGenerator;
import racingcar.rule.MoveRule;
import racingcar.rule.MoveRuleResult;

import java.util.List;

public class RacingCarGame {

    private final RacingReferee racingReferee;
    private final MoveRule moveRule;
    private final ConditionGenerator conditionGenerator;

    private RacingCarGame(RacingReferee racingReferee, MoveRule moveRule, ConditionGenerator conditionGenerator) {
        this.racingReferee = racingReferee;
        this.moveRule = moveRule;
        this.conditionGenerator = conditionGenerator;
    }

    public static void run() {
        System.out.println("경주할 자동자 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)");
        final CarGroup carGroup = createCarGroup();
        System.out.println("시도할 횟수는 몇회인가요?");
        final TryCount tryCount = createTryCount();
        final RacingCarGame racingCarGame = new RacingCarGame(RacingReferee.ofDefault(), MoveRule.ofDefault(),
                                                              ConditionGenerator.random());
        racingCarGame.play(tryCount, carGroup);
    }

    void play(TryCount tryCount, CarGroup carGroup) {
        System.out.println("\n실행 결과");
        tryCount.attempt(() -> {
            doPlay(carGroup);
        });
        final RacingResult result = racingReferee.determine(carGroup);
        printResult(result);
    }

    private void doPlay(CarGroup carGroup) {
        carGroup.forEach(car -> {
            final Condition condition = conditionGenerator.generate(car);
            final MoveRuleResult moveRuleResult = moveRule.tryMove(condition);
            doMoveIfResultIsGo(car, moveRuleResult);
        });
        printResultByTryCount(carGroup);
    }

    private static CarGroup createCarGroup() {
        CarGroup carGroup = null;
        while (carGroup == null) {
            carGroup = validateCarGroup(Console.readLine());
        }
        return carGroup;
    }

    private static CarGroup validateCarGroup(String input) {
        try {
            return CarGroup.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return null;
        }
    }

    private static TryCount createTryCount() {
        TryCount count = null;
        while (count == null) {
            count = parseCount(Console.readLine());
        }
        return count;
    }

    private static TryCount parseCount(String input) {
        try {
            return TryCount.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return null;
        }
    }

    private static void doMoveIfResultIsGo(Car car, MoveRuleResult moveRuleResult) {
        if (MoveRuleResult.GO == moveRuleResult) {
            car.move();
        }
    }

    private static void printResultByTryCount(CarGroup carGroup) {
        final List<Car> cars = carGroup.asList();
        final StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(car.name());
            builder.append(" : ");
            builder.append(toDottedLine(car.position()));
            builder.append('\n');
        }
        System.out.println(builder);
    }

    private static String toDottedLine(int position) {
        final StringBuilder builder = new StringBuilder(position);
        for (int i = 0; i < position; i++) {
            builder.append('-');
        }
        return builder.toString();
    }

    private static void printResult(RacingResult result) {
        final List<Car> cars = result.asList();
        final StringBuilder builder = new StringBuilder();
        builder.append("최종 우승자: ");
        builder.append(extractWinningCars(cars));
        System.out.println(builder);
    }

    private static String extractWinningCars(List<Car> cars) {
        final StringBuilder builder = new StringBuilder();
        builder.append(cars.get(0).name());
        for (int i = 1; i < cars.size(); i++) {
            builder.append(", " + cars.get(i).name());
        }
        return builder.toString();
    }
}
