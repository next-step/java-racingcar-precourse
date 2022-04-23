package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.enums.MoveStatus;
import racingcar.utils.ValidationUtils;

import java.util.HashMap;
import java.util.Map;

public class Move {

    private static final int LEAST_RANGE = 0;
    private static final int NUMBER_OF_MOVES_ONE_TIME = 1;
    private static final int MAXIMUM_RANGE = 9;
    private static final int MOVE_LEAST_RANGE = 4;

    private static final String NUMBER_PATTERN = "[+-]?\\d*(\\.\\d+)?";

    private int moves;

    public Move(String moves) {
        ValidationUtils.validStringThrowIfEmpty(moves, ErrorMessage.MOVE_IS_REQUIRED);
        ValidationUtils.validConditionThrowIfTrue(!moves.matches(NUMBER_PATTERN), ErrorMessage.MOVE_MUST_BE_NUMBER);

        try {
            this.moves = getParseMovesThrowIfNotAllowedInt(moves);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_MUST_BE_ALLOWED_INT);
        }
    }

    private int getParseMovesThrowIfNotAllowedInt(String moves) {
        int parseMoves = Integer.parseInt(moves);
        ValidationUtils.validConditionThrowIfTrue(
                parseMoves < LEAST_RANGE, ErrorMessage.MOVE_MUST_BE_ALLOWED_INT);
        return parseMoves;
    }

    public boolean immovable() {
        return moves < NUMBER_OF_MOVES_ONE_TIME;
    }

    public Map<String, MoveStatus> moveStatus(Map<String, Integer> randomNumberMapByName) {
        final Map<String, MoveStatus> moveStatusMapByName = getMoveStatusMap(randomNumberMapByName);
        this.moves -= NUMBER_OF_MOVES_ONE_TIME;
        return moveStatusMapByName;
    }

    private Map<String, MoveStatus> getMoveStatusMap(Map<String, Integer> randomNumberMapByName) {
        final Map<String, MoveStatus> moveStatusMapByName = new HashMap<>();

        for (Map.Entry<String, Integer> entry : randomNumberMapByName.entrySet()) {
            String name = entry.getKey();
            Integer randomNumber = entry.getValue();
            final MoveStatus moveStatus = getMoveStatus(randomNumber);
            moveStatusMapByName.putIfAbsent(name, moveStatus);
        }

        return moveStatusMapByName;
    }

    private MoveStatus getMoveStatus(Integer randomNumber) {
        ValidationUtils.validObjectThrowIfNull(randomNumber, ErrorMessage.MOVE_MUST_BE_NUMBER);
        ValidationUtils.validConditionThrowIfTrue(randomNumber < LEAST_RANGE || randomNumber > MAXIMUM_RANGE,
                ErrorMessage.MOVE_STATUS_NUMBER_MUST_BE_ALLOWED_RANGE);
        ValidationUtils.validConditionThrowIfTrue(this.moves < 1, ErrorMessage.MUST_HAVE_A_COUNT_TO_MOVE);

        if (randomNumber < MOVE_LEAST_RANGE) {
            return MoveStatus.STAY;
        }

        return MoveStatus.MOVE;
    }

    public int remainMoves() {
        return moves;
    }

}
