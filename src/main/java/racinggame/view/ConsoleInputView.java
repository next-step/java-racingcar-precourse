package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.exceptions.BusinessException;

public class ConsoleInputView {

    public String enterNames() {
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        return Console.readLine();
    }

    public int enterAttempts() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new BusinessException("시도 회수는 숫자만 입력 할 수 있습니다.");
        }
    }
}
