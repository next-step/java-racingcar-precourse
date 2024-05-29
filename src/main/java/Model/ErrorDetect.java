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
}
