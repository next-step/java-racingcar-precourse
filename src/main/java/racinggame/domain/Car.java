package racinggame.domain;

import racinggame.service.MovingStrategy;

public class Car {
    private Position position;
    private CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getCarName() {
        return carName.getValue();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMoving()){
            this.position.addOne();
        }
    }

    public boolean isWinner(int winnerPosition) {
        return getPosition() == winnerPosition;
    }
}
