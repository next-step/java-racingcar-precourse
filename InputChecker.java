

public class InputChecker {

    final static String NAME_ERROR_MESSAGE = "[ERROR] 이름은 5자 이내로 입력하셔야 합니다.";
    final static String NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public void checkName(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].length() > 5) {
                System.out.println(NAME_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkNumber(String numberOfTry) {
        try {
            Integer.parseInt(numberOfTry);
        } catch (NumberFormatException ex) {
            System.out.println(NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}