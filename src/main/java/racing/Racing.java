package racing;

public class Racing {
    
    private final Car car;
    private final int randomNumber;
    
    public Racing(Car car, int randomNumber) {
        this.car = car;
        this.randomNumber = randomNumber;
    }
    
    public int getRandomNumber() {
        return randomNumber;
    }
    
    public int play(Racing racing) {
        if (racing.getRandomNumber() >= 4) {
            return 1;
        }
        return 0;
    }
}
