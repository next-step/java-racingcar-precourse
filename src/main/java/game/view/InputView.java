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

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> enterCarNames() {
        String input = "";
        while (input.isBlank()) {
            System.out.println(InputMessage.CAR_NAME);
            input = scanner.nextLine();
            try {
                CarNameValidator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = "";
            }
        }
        return Arrays.asList(input.split(Rule.NAME_DELIMITER));
    }

    /**
     * 시도 횟수를 입력 받습니다.
     *
     * @return 시도 횟수
     */
    public int enterAttemptCount() {
        String input = "";
        while (input.isBlank()) {
            System.out.println(InputMessage.ATTEMPT_COUNT);
            input = scanner.nextLine();
            try {
                AttemptCountValidator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = "";
            }
        }
        return Integer.parseInt(input);
    }
}
