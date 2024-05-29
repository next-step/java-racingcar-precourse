package racinggame.validator;

public interface InputValidator {

    // 사용자에게 입력받은 자동차 이름이 쉼표로 구분되어 있는지
    void isValidateCarNames(String carNames);
    // 사용자에게 입력받은 시도 회수가 유효한 값인지
    void isValidateInputNum(String inputNum);
}