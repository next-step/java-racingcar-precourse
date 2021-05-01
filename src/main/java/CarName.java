public class CarName {
    private static final String CAR_NAME_CONDITION_EXCEPTION_MSG = "자동차 이름은 5글자 이하이고 비어있지 않아야 합니다.";
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        String trimmedName = name.trim();

        if (trimmedName.length() < NAME_MIN_LENGTH || trimmedName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_CONDITION_EXCEPTION_MSG);
        }

        this.name = trimmedName;
    }
}
