package game.view;

import game.config.constant.Rule;
import game.validator.CarNameValidator;
import game.view.constant.InputMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final CarNameValidator carNameValidator;

    public InputView() {
        scanner = new Scanner(System.in);
        carNameValidator = CarNameValidator.getInstance();
    }

    public List<String> enterCarNames() {
        System.out.println(InputMessage.CAR_NAME);

        String input = scanner.next();
        carNameValidator.validate(input);

        return Arrays.asList(input.split(Rule.NAME_DELIMITER));
    }

}
