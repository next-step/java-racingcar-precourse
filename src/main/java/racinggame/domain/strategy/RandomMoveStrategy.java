package racinggame.domain.strategy;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        int random = (int) (Math.random() * 10);
        return isMove(random);
    }

    private boolean isMove(final int random) {
        return random >= 4 && random < 10;
    }
}
