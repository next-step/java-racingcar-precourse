package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarStringUtils {

    private static final char CHAR_0 = 48;
    private static final char CHAR_9 = 57;

    public static void checkNumberFormat(String value) {
        if(!isNumberFormat(value))
            throw new IllegalArgumentException(Message.NUMBER_FORMAT_EXCEPTION.getMessage());
    }

    public static boolean isNumberFormat(String value) {
        boolean isNumberFormat = true;
        for(char charValue : value.toCharArray()) {
            isNumberFormat = isNumberFormat && isCharNumberFormat(charValue);
        }
        return isNumberFormat;
    }

    private static boolean isCharNumberFormat(char charValue) {
        if(charValue >= CHAR_0 && charValue <= CHAR_9) return true;
        return false;
    }

    public static void checkNotDuplicate(String[] stringList) {
        if(isDuplicate(stringList))
            throw new IllegalArgumentException(Message.STRING_DUPLICATE_EXCEPTION.getMessage());
    }

    public static boolean isDuplicate(String[] stringList) {
        List list = new ArrayList();
        for(String value : stringList) {
            list.add(value);
        }
        return isDuplicate(list);
    }

    public static void checkNotDuplicate(List<String> stringList) {
        if(isDuplicate(stringList))
            throw new IllegalArgumentException(Message.STRING_DUPLICATE_EXCEPTION.getMessage());
    }

    public static boolean isDuplicate(List<String> stringList) {
        Set set = new HashSet<>(stringList);
        return stringList.size() != set.size();
    }

    public static void checkNotEmpty(String value) {
        if(isEmpty(value))
            throw new IllegalArgumentException(Message.STRING_EMPTY_EXCEPTION.getMessage());
    }

    public static boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

    public static void checkMaxLength(String value, int maxLength) {
        if(!underMaxLength(value, maxLength))
            throw new IllegalArgumentException(Message.STRING_MAXLENGTH_EXCEPTION.getMessage() + maxLength);
    }

    public static boolean underMaxLength(String value, int maxLength) {
        if(value.length() <= maxLength) return true;
        return false;
    }

}
