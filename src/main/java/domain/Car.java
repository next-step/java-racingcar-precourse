package domain;

import domain.exceptions.CarException;
import nextstep.utils.Randoms;

public class Car {

    private MoveCount moveCount;
    private Name name;

    public Car(String carName){
        validate(carName);
        name = new Name(carName);
        moveCount = new MoveCount();
    }

    private void validate(String carName) {
        if(carName.length() >5){
            throw new CarException("[ERROR]");
        }
    }

    public void move(){
        int randomNumber = getRandomNumber();
        moveCount.judgeMove(randomNumber);
    }

    protected int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public String getName(){
        return name.getName();
    }

    public int getMoveCount(){
        return moveCount.getMoveCount();
    }


}
