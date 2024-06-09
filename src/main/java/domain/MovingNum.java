package domain;

public class MovingNum {

    private final int movingNum;

    public MovingNum(final String movingNum) {
        isNaturalNumberValidate(movingNum);
        this.movingNum = convertStringToInt(movingNum);
    }

    private void isNaturalNumberValidate(String movingNum) {
        if (!movingNum.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException("이동할 횟수는 자연수여야 한다.");
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getMovingNum() {
        return movingNum;
    }
}
