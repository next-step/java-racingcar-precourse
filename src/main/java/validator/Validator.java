package validator;

public class Validator {
    private static final int NAME_LENGTH_LIMIT = 5;

    /**
     * 자동차 이름의 길이가 NAME_LENGTH_LIMIT 이하 인지 확인
     *
     * @param array
     * return void
     */
    public static void validNameLength(String[] array) {
        for (String name : array) {
            if (name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("[Error] 자동차의 이름은 "+ NAME_LENGTH_LIMIT + "자 이하이어야 한다.\n");
            }
            if (name.length() < 1) {
                throw new IllegalArgumentException("[Error] 자동차의 이름은 1자 이상이어야 한다.\n");
            }
        }
    }

    /**
     * 자동차 이름 배열의 길이가 0보다 큰지 확인
     * @param array
     * return void
     */
    public static void validArrayExist(String[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("[Error] 1개 이상의 자동차를 입력해주세요.\n");
        }
    }

    /**
     * 전진을 시도할 횟수가 0이상, int 범위 이하인지 확인
     *
     * @param input
     * return void
     */
    public static void validRacingCount(String input) {
        long longValue = Long.parseLong(input);
        if (longValue < 0 || longValue > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[Error] 시도할 횟수는 "
                    + "0이상 이고 "
                    + Integer.MAX_VALUE
                    + "보다 작아야 한다.\n"
                    );
        }
    }

    /**
     *  전진을 시도할 횟수가 숫자이어야 한다.
     * @param input
     * return void
     */
    public static void validNumberFormat(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 시도할 횟수는 숫자이어야 한다.\n");
        }
    }
}
