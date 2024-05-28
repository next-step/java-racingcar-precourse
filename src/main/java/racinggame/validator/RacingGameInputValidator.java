package racinggame.validator;

public class RacingGameInputValidator implements InputValidator{

    @Override
    public void isValidateCarNames(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열이 올 수 없습니다.");
            }
            if (name.trim().length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    @Override
    public void isValidateInputNum(String inputNum) {
        try {
            int count = Integer.parseInt(inputNum);
            if (count <= 0){
                throw new IllegalArgumentException("[ERROR] 시도 가능한 수는 양의 정수입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자여야 합니다.");
        }
    }
}