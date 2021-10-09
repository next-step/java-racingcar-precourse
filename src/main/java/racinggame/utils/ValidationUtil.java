package racinggame.utils;

public class ValidationUtil {

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

    public static boolean isValidateName(final String name) {
        if (name.length() == 0 || name.length() > 5) {
            System.out.println("[ERROR] 올바른 이름을 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean isValidateCount(final String countString) {
        if (!isInteger(countString) || Integer.parseInt(countString) < 1) {
            System.out.println("[ERROR] 숫자는 1 이상만 가능합니다.");
            return false;
        }
        return true;
    }

    public static boolean isInteger(final String integerString) {
        try {
            Integer.parseInt(integerString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
