package racing.model;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String INVALID_VALUE_EXCEPTION_MESSAGE = "1~5자 이내의 이름을 입력하십시오.";

    private final String name;

    public Name(final String name) {
        validateValue(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 유효성 검사
     *
     * @param name
     */
    private void validateValue(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_VALUE_EXCEPTION_MESSAGE);
        }
    }

}
