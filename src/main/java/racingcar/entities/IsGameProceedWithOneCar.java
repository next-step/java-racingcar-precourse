package racingcar.entities;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.entities.NamesInput.PROCEED_GAME_WITH_ONE_CAR;
import static racingcar.entities.NamesInput.RE_READ_LINE_CODE;

public class IsGameProceedWithOneCar {
    private String input;
    public IsGameProceedWithOneCar(String input) {
        while (true) {
            try {
                this.input = input;
                validateIsNameIsOneInput(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input=readLine();
            }
        }
    }

    private static void validateIsNameIsOneInput(String input) {
        if (!input.equals(PROCEED_GAME_WITH_ONE_CAR) && !input.equals(RE_READ_LINE_CODE)) {
            throw new IllegalArgumentException(ErrorScenario.WRONG_ISGAMEPROCEEDWITHONECAR_INPUT.getErrorPhrases());
        }
    }

    public String getInput() {
        return input;
    }
}
