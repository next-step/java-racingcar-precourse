package racinggame.domain;

public class Car {
    private final String carName;
    private int randomNum;
    private int moveCnt;

    private RandomNumber randomNumber;

    public Car(String carName) {
        this.carName = carName;
        this.moveCnt = 0;
    }

    public void play() {
        this.randomNumber = new RandomNumber();
        randomNum = randomNumber.randomNum;
        if (canMove(randomNum)) {
            this.moveCnt++;
        }
    }

    private Boolean canMove(int randomNum) {
        return randomNum >= 4;
    }

    public int getMoveCnt() {
        return this.moveCnt;
    }

    public String getCarName() {
        return this.carName;
    }
}
