package racingcar.common;

import org.junit.platform.commons.util.StringUtils;
import racingcar.constant.ErrorConstants;

import java.util.Objects;

public class UserString {

    private static final String delimiter = ",";
    private final String userInput;

    public UserString(String userInput) {
        validate(userInput);
        this.userInput = userInput.trim();
    }

    public static UserString of(String s) {
        return new UserString(s);
    }

    private void validate(String userInput) {
        if (StringUtils.isBlank(userInput)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_USER_INPUT_BLANK);
        }
    }

    public UserString[] split() {
        String[] split = userInput.split(delimiter);
        UserString[] result = new UserString[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = UserString.of(split[i]);
        }
        return result;
    }

    public int length() {
        return this.userInput.length();
    }

    @Override
    public String toString() {
        return userInput;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserString))
            return false;

        UserString userString = (UserString) o;
        return this.userInput.equals(userString.userInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInput);
    }

    public char charAt(int i) {
        return this.userInput.charAt(i);
    }
}
