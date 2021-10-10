package racinggame.domain;

import racinggame.domain.exceptions.CarException;

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

    public void move(int randomNumber){
        moveCount.judgeMove(randomNumber);
    }

    public String getName(){
        return name.getName();
    }

    public int getMoveCount(){
        return moveCount.getMoveCount();
    }


}
