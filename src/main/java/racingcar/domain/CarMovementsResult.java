package racingcar.domain;

import java.util.List;

public class CarMovementsResult {

    private final CarName name;
    private final Movements movements;

    public CarMovementsResult(CarName name, Movements movements) {
        this.name = name;
        this.movements = movements;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getMovementsAsString());
    }

    private String getMovementsAsString() {
        List<MoveType> moveTypes = movements.getList();

        final StringBuilder builder = new StringBuilder();
        for (MoveType moveType : moveTypes) {
            builder.append(moveType == MoveType.FORWARD ? "-" : "");
        }

        return builder.toString();
    }
}
