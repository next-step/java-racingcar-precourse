package game.view;

import game.config.constant.Rule;
import game.validator.AttemptCountValidator;
import game.validator.CarNameValidator;
import game.view.constant.InputMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final CarNameValidator carNameValidator;
    private final AttemptCountValidator attemptCountValidator;

    public InputView() {
        scanner = new Scanner(System.in);
        carNameValidator = CarNameValidator.getInstance();
        attemptCountValidator = AttemptCountValidator.getInstance();
    }

    public List<String> enterCarNames() {
        System.out.println(InputMessage.CAR_NAME);

        String input = scanner.next();
        carNameValidator.validate(input);

        return Arrays.asList(input.split(Rule.NAME_DELIMITER));
    }

    /**
     * 시도 횟수를 입력 받습니다.
     *
     * @return 시도 횟수
     */
    public int enterAttemptCount() {
        System.out.println(InputMessage.ATTEMPT_COUNT);

        String input = scanner.next();
        attemptCountValidator.validate(input);

        return Integer.parseInt(input);
    }
}
