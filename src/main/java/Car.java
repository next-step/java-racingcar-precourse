public class Car {
    public static final int FORWARD_RANDOM_VALUE = 4;
    public static final int STAY_RANDOM_VALUE = 0;

    private MoveHistory moveHistory;
    private CarName carname;

    public Car(CarName carname) {
        this.carname = carname;

        this.moveHistory = new MoveHistory();
    }

    public MoveResult tryMove(int randomValue) {
        if (randomValue >= FORWARD_RANDOM_VALUE) {
            this.moveHistory.add(new Movement());

            return MoveResult.FORWARD;
        }

        return MoveResult.STAY;
    }

    public int getMoveCount() {
        return this.moveHistory.countMoves();
    }

    public CarName getCarName() {
        return this.carname;
    }

    public String printMoveHistory() {
        return this.moveHistory.toString();
    }
}
