package domain;

public class Car {

    private MoveCount moveCount;
    private Name name;

    public Car(String carName){
        name = new Name(carName);
        moveCount = new MoveCount();
    }

    public String ofName(){
        return name.getName();
    }

    public int ofMoveCount(){
        return moveCount.getMoveCount();
    }


}
