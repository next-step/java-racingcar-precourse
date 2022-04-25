package racingcar.Model.Racing.Result;

public class ResultViewer {
    private final MovementViewer movementViewer;
    private final WinnerViewer winnerViewer;

    public ResultViewer(MovementViewer movementViewer, WinnerViewer winnerViewer) {
        this.movementViewer = movementViewer;
        this.winnerViewer = winnerViewer;
    }

    public void printMovement() {
        this.movementViewer.startMoving();
    }

    public void printWinner() {
        this.winnerViewer.printWinner();
    }
}
