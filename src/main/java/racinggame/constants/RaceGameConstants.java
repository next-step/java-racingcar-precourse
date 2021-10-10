package racinggame.constants;

import java.util.regex.Pattern;

public class RaceGameConstants {
    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 9;
    public static final int NAME_LENGTH_MIN = 1;
    public static final int NAME_LENGTH_MAX = 5;
    public static final int MOVING_FORWARD = 4;
    public static final String SPLIT_REGEX = ",";
    public static final String JOIN_REGEX = ",";
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*?");
}
