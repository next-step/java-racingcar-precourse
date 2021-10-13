package racinggame.domain;

import racinggame.ui.ResultView;

public class Car {

    private MoveCount moveCount;
    private Name name;

    public Car(String carName){
        name = new Name(carName);
        moveCount = new MoveCount();
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
