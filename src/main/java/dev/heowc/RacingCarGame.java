package dev.heowc;

import dev.heowc.car.RacingCarGroup;
import dev.heowc.car.WinnerGroup;
import dev.heowc.condition.Condition;
import dev.heowc.condition.ConditionGenerator;

import java.io.PrintStream;

public class RacingCarGame {

    private final ConditionGenerator conditionGenerator;
    private final Condition standardCondition;

    public RacingCarGame(ConditionGenerator conditionGenerator, Condition standardCondition) {
        this.conditionGenerator = conditionGenerator;
        this.standardCondition = standardCondition;
    }

    public static RacingCarGame init(ConditionGenerator conditionGenerator, Condition standardCondition) {
        return new RacingCarGame(conditionGenerator, standardCondition);
    }

    public void run(PrintStream outView, String carNames, int countOfAttempts) {
        outView.println();
        outView.println("실행결과");
        final RacingCarGroup group = RacingCarGroup.create(carNames, standardCondition);
        for (int i = 0; i < countOfAttempts; i++) {
            doAttempt(group, conditionGenerator);
            printRoundResult(outView, group);
        }
        final WinnerGroup winnerGroup = WinnerGroup.create(group);
        outView.printf("%s가 최종 우승했습니다.", winnerGroup.names());
    }

    private static void doAttempt(RacingCarGroup group, ConditionGenerator conditionGenerator) {
        group.forEach(car -> {
            final Condition condition = conditionGenerator.generate();
            car.tryMove(condition);
        });
    }

    private static void printRoundResult(PrintStream outView, RacingCarGroup carGroup) {
        carGroup.forEach(outView::println);
        outView.println();
    }
}
