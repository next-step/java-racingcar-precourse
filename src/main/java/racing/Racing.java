package racing;

public class Racing {
    
    private final Car car;
    private final RandomNumber randomNumber;
    
    public Racing(Car car, int randomNo) {
        this.car = car;
        this.randomNumber = new RandomNumber(randomNo);
    }
    
    public RandomNumber getRandomNumber() {
        return randomNumber; 
    }
    
    public void play(Racing racing) {
        if (isMoveNumber()) {
            car.move(racing);
        }
    }
    
    private boolean isMoveNumber() {
        return randomNumber.getRandomNumber() >= 4;
    }
    
}
