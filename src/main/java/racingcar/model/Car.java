package racingcar.model;

public class Car {
    private final Move move;
    private final Name name;

    public Car(Name name) {
        this.name = name;
        this.move = new Move();
    }

    public Car(Name name, Move move) {
        this.move = move;
        this.name = name;
    }

    public void move(int randomNumber) {
        move.move(randomNumber);
    }

    public String getName() {
        return this.name.getName();
    }

    public Car compareEqualMove(Move move) {
        if (this.move.matchMoveCount(move)) {
            return this;
        }

        return null;
    }

    public Move getMove(){
        return move;
    }
}