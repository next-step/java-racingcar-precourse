package racingcar;

public class TryNumber {
    int tryCount;

    public TryNumber(String checkNumberString) throws IllegalArgumentException {
        try {
            tryCount = Integer.parseInt(checkNumberString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR]시도횟수는 자연수를 입력해주세요");
        }
        if (tryCount <= 0) {
            throw new IllegalArgumentException("[ERROR]시도횟수는 자연수를 입력해주세요");
        }
    }
}
