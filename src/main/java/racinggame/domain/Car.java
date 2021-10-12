package racinggame.domain;

import racinggame.domain.exceptions.CarException;
import racinggame.ui.ResultView;

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
            throw new CarException("[ERROR] 다섯자 미만의 이름을 입력해 주세요");
        }
    }

    public void move(int randomNumber){
        moveCount.judgeMove(randomNumber);
        ResultView.printPlayResult(name,moveCount);
        ResultView.lineBreak();
    }

    public String getName(){
        return name.getName();
    }

    public int getMoveCount(){
        return moveCount.getMoveCount();
    }

}
