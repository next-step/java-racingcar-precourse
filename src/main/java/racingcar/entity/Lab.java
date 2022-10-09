package racingcar.entity;

public class Lab {
    private int labCount;

    public Lab() {
        checkLabExist("");
        checkDigit("");
        checkPositive();
    }

    public Lab(String inputValue) {
        checkLabExist(inputValue);
        checkDigit(inputValue);
        labCount = Integer.parseInt(inputValue);
        checkPositive();
    }

    public int getLabCount() {
        return labCount;
    }

    private void checkLabExist(String labCount) {
        if (labCount.length() < 1) {
            throw new IllegalStateException("[ERROR] 시도할 회수 입력값이 존재하지 않습니다.");
        }
    }

    private void checkDigit(String labCount) {
        if (!labCount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 숫자만 입력 가능합니다.");
        }
    }

    private void checkPositive() {
        if (labCount < 1) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 1이상의 숫자만 입력 가능합니다.");
        }
    }
}
