package View;

public class RacingGameExceptionHandler {
    public RacingGameExceptionHandler() {
    }

    public boolean isRightString(String input){

        String[] carNames = input.split(",", -1);
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                return false; // 자동차 이름이 비어있거나 5자를 초과하는 경우 유효하지 않음
            }
        }
        return true;

    }



    public boolean isInt(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
