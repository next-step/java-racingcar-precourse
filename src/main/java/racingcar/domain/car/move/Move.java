package racingcar.domain.car.move;

public interface Move {

    String MOVE_FORWARD = "-";

    String move(int random);

    int moveCount();
}
