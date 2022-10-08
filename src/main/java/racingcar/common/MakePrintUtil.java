package racingcar.common;

import java.util.List;

import static racingcar.common.Constants.*;

public class MakePrintUtil {

    public static StringBuilder convertMove(int move) {
        StringBuilder builder = new StringBuilder();

        for (int i = INIT_INDEX; i < move; i++) {
            builder.append(CAR_MOVE_PRINT);
        }

        return builder;
    }

    public static StringBuilder convertWinner(List<String> winner) {
        StringBuilder builder = new StringBuilder();

        for (int i = INIT_INDEX; i < winner.size(); i++) {
            addWinner(builder, winner, i, winner.size());
        }

       return builder;
    }

    private static void addWinner(StringBuilder builder, List<String> winner, int index, int size) {
        builder.append(winner.get(index));

        if (size != index + INIT_INDEX) {
            builder.append(CAR_ADDITIONAL_ADD);
        }
    }
}
