package racing;

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
    
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public int getCurrentPosition() {
        return position; 
    }
    
    public void move() {
        position++;
    }
    
    public String getCarName() {
        return name;
    }
    
    private boolean isNameLengthExcessLimit(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}
