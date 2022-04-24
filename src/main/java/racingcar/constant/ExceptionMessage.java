package racingcar.constant;

public class ExceptionMessage {
    public static final String ERROR_PREFIX = "[ERROR]";

    public static final String CAR_NAME_CANNOT_BE_EMPTY = ERROR_PREFIX + " Car name cannot be empty.";
    public static final String DUPLICATED_CAR_NAMES_PROVIDED = ERROR_PREFIX + " Duplicated car names provided.";
    public static final String CAR_NAME_LENGTH_INVALID = ERROR_PREFIX + String.format(" Invalid car name length provided. Must be %s characters or less.", CarNameCondition.CAR_NAME_MAX_LENGTH);
    public static final String INCOMPLETE_INPUT_PROVIDED = ERROR_PREFIX + " Incomplete input provided.";
    public static final String ROUND_COUNT_CANNOT_BE_EMPTY = ERROR_PREFIX + " Round count cannot be empty.";
    public static final String ROUND_COUNT_CANNOT_LESS_THAN_ONE = ERROR_PREFIX + " Round count cannot be less than one.";
    public static final String ROUND_COUNT_INVALID_TYPE = ERROR_PREFIX + " Invalid round count provided. Must be integer value";
}
