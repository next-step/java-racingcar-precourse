package racingcar.domain;

import racingcar.common.CarMessage;
import racingcar.common.ExcMessage;

import java.util.regex.Pattern;

public class Round {
    public int round = 0;

    public Round(){

    }

    public Round(int round){
        validateCheck(String.valueOf(round));
        this.round = round;
    }

    public void validateCheck(String input){
        isCheck(input);
        inputRegex(input);
    }

    public int getRound() {
        return round;
    }

    public void isCheck(String input){
        if(input.length() == 0) throw new IllegalArgumentException(ExcMessage.ERROR_EMPTY);
    }

    public void inputRegex(String input){
        if(!Pattern.matches(ExcMessage.NUMBER_REGEX, input)) throw new IllegalArgumentException(ExcMessage.ERROR_NUMBER);
    }
}
