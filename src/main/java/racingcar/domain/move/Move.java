package racingcar.domain.move;

import java.util.function.Supplier;

public class Move {

    private final Supplier<Integer> generator;

    public Move(Supplier<Integer> generator) {
        this.generator = generator;
    }

    public MoveType goOrStop() {
        MoveNumber moveNumber = MoveNumber.valueOf(generator.get());
        return moveNumber.get();
    }
}
