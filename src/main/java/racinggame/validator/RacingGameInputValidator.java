package racinggame.validator;

public class RacingGameInputValidator implements InputValidator{


    // 사용자에게 입력받은 자동차 이름이 유효한지 검사
    @Override
    public void isValidateCarNames(String carNames) {
        // 자동차의 이름은 , 로 구분
        String[] names = carNames.split(",");
        for (String name : names) {
            // 만약 , 뒤에 아무것도 오지 않았다면
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열이 올 수 없습니다.");
            }
            // 만약 자동차의 이름이 5글자가 넘는다면
            if (name.trim().length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    @Override
    public void isValidateInputNum(String inputNum) {
        try {
            int count = Integer.parseInt(inputNum);
            // 숫자가 음수라면
            if (count <= 0){
                throw new IllegalArgumentException("[ERROR] 시도 가능한 수는 양의 정수입니다.");
            }
        } catch (NumberFormatException e) {
            // Integer.parseInt에서 정수가 아닌 오류가 발생하였다면
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자여야 합니다.");
        }
    }
}