package racingcar.domain;

import racingcar.enums.Action;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void determineMovement(){
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.canMove(randomNumber.getRandomNumber())){
            moveForward();
        }
    }

    private void moveForward(){
        this.position.addCarPosition(Action.MOVE);
    }
}
