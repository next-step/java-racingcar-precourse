public class Car {
    private static final int GO_FORWARD_MIN = 4;

    private MoveHistory moveHistory;

    public Car() {
        this.moveHistory = new MoveHistory();
    }

    public MoveResult tryMove(int randomValue) {
        if (randomValue >= GO_FORWARD_MIN) {
            this.moveHistory.add(new Movement());

            return MoveResult.FORWARD;
        }

        return MoveResult.STAY;
    }

    public int getMoveCount() {
        return this.moveHistory.countMoves();
    }

    public String printMoveHistory() {
        return this.moveHistory.toString();
    }
}
