package Model;

public class ErrorDetect {
    private ErrorDetect() {};

    public static void carNameTest(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백을 포함할 수 없습니다.");
        }
    }

    public static void roundsTest(String roundsInput) {
        int temp;
        String intLimit = "2147483648";

        for (int i = 0; i < roundsInput.length(); i++) {
            temp = roundsInput.charAt(i);

            if ( 48 > temp | temp > 57) {
                throw new IllegalArgumentException("[ERROR] 라운드는 1 이상의 정수만 입력할 수 있습니다.");
            }
        }

        if (roundsInput.compareTo(intLimit) < 0) {
            throw new IllegalArgumentException("[ERROR] 라운드의 수가 유효 범위를 벗어났습니다.");
        }
    }
}
