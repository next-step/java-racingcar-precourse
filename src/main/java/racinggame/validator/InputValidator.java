package racinggame.validator;

public interface InputValidator {

    // 사용자에게 입력받은 자동차 이름이 쉼표로 구분되어 있는지
    boolean isValidateCarNames(String carNames);
    boolean isValidateInputNum(String inputNum);
}