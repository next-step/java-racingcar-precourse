package racing;

import static racing.RandomNumber.MOVABLE_MINIMUM_NUMBER;

public class Racing {

    private final int number;
    private final Car car;

    public Racing(Car car, int number) {
        this.car = car;
        this.number = number;
    }
    
    public int getRandomNumber() {
        return number; 
    }
    
    public void play(Racing racing) {
        if (isMoveNumber()) {
            car.move(racing);
        }
    }
    
    private boolean isMoveNumber() {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }
    
}
