package racing;

import static racing.RandomNumber.MOVABLE_MINIMUM_NUMBER;

public class Car {
    
    public static final String CAR_NAME_LENGTH_LIMIT_MESSAGE = "자동차 이름은 5글자까지만 가능합니다.";
    public static final int NAME_LENGTH_LIMIT = 5;
    
    private String name;
    private int position = 0;
    
    public Car(String name) {
        if (isNameLengthExcessLimit(name)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_MESSAGE);
        }
        this.name = name;
    }
    
    public int getCurrentPosition() {
        return position; 
    }
    
    public String getCarName() {
        return name;
    }
    
    public void play(int number) {
        if (isMovableNumber(number)) {
            move();
        }
    }
    
    public void move() {
        position++;
    }
    
    private boolean isMovableNumber(int number) {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }
    
    private boolean isNameLengthExcessLimit(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
    
}
