package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.MessageUtil;
import racingcar.validator.Validator;

public class InputView {

    private InputView() {
    }

    public static int inputRound() {
        System.out.println(MessageUtil.CAR_ROUND_MESSAGE);

        String round = Console.readLine();

        try {
            Validator.validatorRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRound();
        }

        return Integer.parseInt(round);
    }

    public static String[] inputNames() {
        System.out.println(MessageUtil.CAR_NAMES_INPUT_MESSAGE);

        String inputName = Console.readLine();
        String[] names = inputName.split(",");

        try {
            Validator.validatorNames(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }

        return names;
    }

}
