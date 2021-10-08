package domain;

public class Car {

    private MoveCount moveCount;
    private Name name;

    public Car(String carName){
        name = new Name(carName);
        moveCount = new MoveCount();
    }

    public String getName(){
        return name.getName();
    }

    public int getMoveCount(){
        return moveCount.getMoveCount();
    }


}
