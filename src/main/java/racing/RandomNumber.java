package racing;

import java.util.Random;

public class RandomNumber {

    public static final int MINIMUM_NUMBER = 0;
    public static final int MOVABLE_MINIMUM_NUMBER = 4;
    public static final int MAXIMUM_NUMBER = 9;
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "랜덤 숫자는 0~9 사이여야 합니다.";
    
    private final int number;
    
    public RandomNumber() {
        this.number = generateRandomNumber();
        if(!isAvailable(this.number)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    public int getRandomNumber() {
        return number;
    }
    
    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
    
    private boolean isAvailable(int number) {
        return number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER;
    }
    
}
