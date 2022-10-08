package racingcar.model;

public class Car {
    private final CarName name;
    private final CarMove move;


    public Car(CarName name, CarMove move) {
        this.name = name;
        this.move = move;
    }

    public void race(int randomNumber) {
        this.move.updateMoveIfWin(randomNumber);
    }

    public String getName() {
        return name.getName();
    }

    public int getMove() {
        return move.getMove();
    }

    public CarMove move() {
        return move;
    }

    public static Car participate(String inputName, int moveCount) {
        return new Car(new CarName(inputName), new CarMove(moveCount));
    }
}
