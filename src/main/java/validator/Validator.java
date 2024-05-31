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
                throw new IllegalArgumentException("[Error] 자동차의 이름은 "+ NAME_LENGTH_LIMIT + "자 이하이어야 한다.");
            }
        }
    }
}
