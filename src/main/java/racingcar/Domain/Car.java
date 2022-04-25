package racingcar.Domain;


public class Car {
    public static final int CAN_MOVE_NUMBER = 4;
    private final CarName carName;
    private final Position position;
    private final Winner winner;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
        this.winner = new Winner();
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
        this.winner = new Winner();
    }

    public void move(int randomNumber) {
        if (randomNumber >= CAN_MOVE_NUMBER) {
            position.canMove();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPostion();
    }

    public void comparePosition(int winnerPosition) {
        if (position.getPostion() == winnerPosition) {
            winner.thisCarWinner();
        }
    }

    public boolean isWinner() {
        return winner.isWinner();
    }

}
