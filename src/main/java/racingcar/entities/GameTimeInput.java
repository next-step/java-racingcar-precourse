package racingcar.entities;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameTimeInput {

    private int gameTime;

    public GameTimeInput(String stringInput) {
        while (true) {
            try {
                validateGameTimeInput(stringInput);
                this.gameTime = Integer.parseInt(stringInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                stringInput = readLine();
            }
        }
    }

    private void validateGameTimeInput(String stringInput) {
        if (stringInput.equals("0"))
            throw new IllegalArgumentException(ErrorScenario.GAMETIMEINPUT_IS_ZERO.getErrorPhrases());
        if (!stringInput.matches("[0-9]+"))
            throw new IllegalArgumentException(ErrorScenario.WRONG_GAMETIMEINPUT.getErrorPhrases());
    }

    public int getGameTime() {
        return gameTime;
    }
}
