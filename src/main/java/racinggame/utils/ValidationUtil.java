package racinggame.utils;

public class ValidationUtil {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALIDATE_NAME = "올바른 이름을 입력해주세요.";
    private static final String AT_LEAST_ONE = "숫자는 1 이상만 가능합니다.";

    private static final int NAME_MAX_LENGTH = 5;

    private static final int COUNT_MIN = 1;

    public static boolean isValidateNameArray(final String[] nameArray) {
        boolean isValidate = true;
        int length = nameArray.length;
        int idx = 0;

        while (isValidate && length > idx) {
            isValidate = isValidateName(nameArray[idx]);
            idx++;
        }
        return isValidate;
    }

    private static boolean isValidateName(final String name) {
        if (name.length() == 0 || name.length() > NAME_MAX_LENGTH) {
            System.out.println(ERROR_MESSAGE + INVALIDATE_NAME);
            return false;
        }
        return true;
    }

    public static int getValidateCount(final String countString) {
        if (!isValidateCount(countString)) {
            System.out.println(ERROR_MESSAGE + AT_LEAST_ONE);
            return 0;
        }
        return Integer.parseInt(countString);
    }

    public static boolean isValidateCount(final String countString) {
        if (!isNumber(countString) || Integer.parseInt(countString) < COUNT_MIN) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(final String intString) {
        try {
            Integer.parseInt(intString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
