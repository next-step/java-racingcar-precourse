package util;

public class Validator {

    public static int validateAttemptCount(String userInput) {
        // 빈 문자열 검증
        try {
            int parsedUserInput = Integer.parseInt(userInput);

            // 길이 검증
            if (parsedUserInput < 1) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
            }

            return parsedUserInput;
        } catch (NumberFormatException e) {
            // Integer.parseInt() 오류 시 발생하는 에러
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public static String validateCarName(String userInput) {
        if (userInput.isEmpty() || userInput.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 1자 이상, 5자 이하여야 합니다.");
        }
        return userInput;
    }

}
