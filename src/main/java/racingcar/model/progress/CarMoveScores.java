package racingcar.model.progress;

import racingcar.model.cars.factory.Title;

public class CarMoveScores {
    private final Title title;
    private final MoveScores moveScores;

    public CarMoveScores(Title title, MoveScores moveScores) {
        this.title = title;
        this.moveScores = moveScores;
    }

    public Title getTitle() {
        return title;
    }

    public MoveScores getMoveScores() {
        return moveScores;
    }
}
