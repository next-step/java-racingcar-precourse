import resulttypes.MoveResult;

public class Car {
    public static final int MOVE_MIN_RANDOM_VALUE = 4;
    public static final int STAY_MAX_RANDOM_VALUE = 3;
    private static final String MOVE_COUNT_STRING_FORMAT = " (%d)";

    private MoveHistory moveHistory;

    public Car() {
        this.moveHistory = new MoveHistory();
    }

    public MoveResult tryMove(int randomValue) {
        if (randomValue >= MOVE_MIN_RANDOM_VALUE) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.printMoveHistory());
        sb.append(String.format(MOVE_COUNT_STRING_FORMAT, this.getMoveCount()));

        return sb.toString();
    }
}
