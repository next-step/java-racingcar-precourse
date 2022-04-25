package racingcar.model;

import racingcar.exception.UserInputException;
import racingcar.view.RacingGameUi;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private String name;
    private int pos;

    public Car(String name){
        this.name = name.trim();
        this.pos = 0;
        checkNameValidation();
    }

    private void checkNameValidation(){
        if(this.name.length() > Rule.CAR_NAME_MAX_LEN)
            throw new UserInputException(Message.ERROR_NAME_LEN_OVER);

        if("".equals(this.name))
            throw new UserInputException(Message.ERROR_NAME_USE_NOT_SPACE);
    }

    public String getName(){
        return name;
    }

    public int getPos(){
        return pos;
    }

    public void move() {
        int next = pickNumberInRange(Rule.RAND_RANGE_MIN, Rule.RAND_RANGE_MAX);
        if(next >= Rule.CAR_MOVE_STAND){
            this.pos++;
        }
    }

    public void printPosition() {
        RacingGameUi.printCarNameAndPosition(this.name, this.pos);
    }
}
