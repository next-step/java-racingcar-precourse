package dev.heowc;

import dev.heowc.condition.Condition;
import dev.heowc.condition.ConditionGenerator;

import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        final ConditionGenerator conditionGenerator = ConditionGenerator.random();
        final Condition standardCondition = Condition.of(4);
        final RacingCarGame game = RacingCarGame.init(conditionGenerator, standardCondition);
        System.out.println("경주할 자동자 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final Scanner scanner = new Scanner(System.in);
        final String carNames = scanner.nextLine();
        System.out.println("시도할 횟수는 몇회인가요?");
        final int countOfAttempts = scanner.nextInt();
        game.run(System.out, carNames, countOfAttempts);
    }
}
