package racing;

public class RandomNumber {

    public static final int MINIMUM_NUMBER = 0;
    public static final int NO_MOVE_MAXIMUM_NUMBER = 3;
    public static final int MOVE_MINIMUM_NUMBER = 4;
    public static final int MAXIMUM_NUMBER = 9;
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "랜덤 숫자는 0~9 사이여야 합니다.";
    
    private final int number;
    
    public RandomNumber(int number) {
        if(isNotAvailable(number)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        this.number = number;
    }
    
    public int getRandomNumber() {
        return number;
    }
    
    private boolean isNotAvailable(int number) {
        return number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER;
    }
    
}
