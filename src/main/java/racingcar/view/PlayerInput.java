package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ExceptionMessage;
import racingcar.constant.RacingGameMessage;
import racingcar.domain.Name;
import racingcar.domain.RacingGameStep;

public class PlayerInput {

    private static final String INPUT_CAR_NAMES_SEPARATOR = ",";
    private static final String NUMBER_FORMAT_REG_EXP = "^[0-9]+$";

    public List<Name> inputNames() {
        System.out.println(RacingGameMessage.GUIDE_MESSAGE_INPUT_CAR_NAMES);
        String inputNames = Console.readLine();

        try {
            validateInputNames(inputNames);
            return nameConvertBy(inputNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    public RacingGameStep inputRacingGameStep() {
        System.out.println(RacingGameMessage.GUIDE_MESSAGE_INPUT_RACING_GAME_STEP);
        String racingGameStep = Console.readLine();

        try {
            validateInputRacingGameStep(racingGameStep);
            return racingGameStepConvertBy(racingGameStep);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRacingGameStep();
        }
    }

    private RacingGameStep racingGameStepConvertBy(String racingGameStep) {
        return RacingGameStep.from(Integer.parseInt(racingGameStep));
    }

    private void validateInputRacingGameStep(String racingGameStep) {
        if (isEmpty(racingGameStep)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_RACING_GAME_STEP);
        }

        if (!racingGameStep.matches(NUMBER_FORMAT_REG_EXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER_INPUT_RACING_GAME_STPE);
        }
    }

    private List<Name> nameConvertBy(String inputNames) {
        List<Name> names = new ArrayList<>();
        String[] splitInputNames = inputNames.split(INPUT_CAR_NAMES_SEPARATOR);
        for (String inputName : splitInputNames) {
            names.add(Name.from(inputName));
        }
        return names;
    }

    private void validateInputNames(String inputNames) {
        if (isEmpty(inputNames)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_CAR_NAMES);
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }
}
