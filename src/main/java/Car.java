public class Car {
    private static final int GO_FORWARD_MIN = 4;

    public MoveResult tryMove(int randomValue) {
        return randomValue >= GO_FORWARD_MIN ? MoveResult.FORWARD : MoveResult.STAY;
    }
}
