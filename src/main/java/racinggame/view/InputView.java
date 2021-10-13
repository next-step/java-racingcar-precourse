package racinggame.view;

import nextstep.utils.Console;
import racinggame.LapCountValidator;
import racinggame.domain.CarNames;

public class InputView {
    public static CarNames getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        try {
            return new CarNames(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    public static int getLapCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String lapCount = Console.readLine();
        try {
            LapCountValidator.validate(lapCount);
            return Integer.parseInt(lapCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLapCount();
        }
    }
}
