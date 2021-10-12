package racinggame.domain;

public class Car implements Comparable<Car> {
    public static final int INITIAL_MOVE_CNT = 0;
    public static final int MOVE_OK = 4;

    private final String carName;
    private int randomNum;
    private int moveCnt;

    private RandomNumber randomNumber;

    public Car(String carName) {
        this.carName = carName;
        this.moveCnt = INITIAL_MOVE_CNT;
    }

    public void play() {
        this.randomNumber = new RandomNumber();
        randomNum = randomNumber.randomNum;
        if (canMove(randomNum)) {
            this.moveCnt++;
        }
    }

    private Boolean canMove(int randomNum) {
        return randomNum >= MOVE_OK;
    }

    public int getMoveCnt() {
        return this.moveCnt;
    }

    public String getCarName() {
        return this.carName;
    }


    @Override
    public int compareTo(Car car) {
        if (car.getMoveCnt() < moveCnt) {
            return 1;
        } else if (car.getMoveCnt() > moveCnt) {
            return -1;
        }
        return 0;
    }
}
