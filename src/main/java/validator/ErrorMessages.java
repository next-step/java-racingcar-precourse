package validator;

public interface ErrorMessages {
    public String NAME_DUPLICATED = "[ERROR] 중복된 자동차 이름이 존재합니다.";
    public String NAME_TOO_LONG = "[ERROR] 자동차 이름의 길이는 5이하여야 합니다.";
    public String NAME_TOO_SHORT = "[ERROR] 자동차 이름의 길이는 1이상이어야 합니다.";
}
