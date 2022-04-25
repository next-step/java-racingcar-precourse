package racingcar.domain;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NOT_NUMBER;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_ONE_LESS;

import org.junit.platform.commons.util.StringUtils;

public class GameOperator implements GameInput{
    private int numberGames;
    private int numberTurns;

    public GameOperator(){
        this.numberTurns = 0;
    }

    public void runTurn(){
        this.numberTurns++;
    }

    public boolean isSameNumberGames(String numberGamesString){
        return Integer.parseInt(numberGamesString) == numberGames;
    }

    public boolean isTurnEnd(){
        return numberGames == numberTurns;
    }

    private int numberGamesValidation(String numberGamesString){
        if (StringUtils.isBlank(numberGamesString)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);
        }
        if (!numberGamesString.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NOT_NUMBER);
        }
        int numberGames = Integer.parseInt(numberGamesString);
        if (numberGames < 1){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_ONE_LESS);
        }
        return numberGames;
    }

    @Override
    public void gameStartInput(String input) {
        this.numberGames = numberGamesValidation(input);
    }
}
