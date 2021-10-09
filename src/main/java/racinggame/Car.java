package racinggame;

import nextstep.utils.Randoms;

public class Car {
    private final String carNames;
    private int randomNum;
    private int moveCnt;

    private RandomNumber randomNumber;

    public Car(String carNames) {
        this.carNames = carNames;
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
        System.out.println("웁직임은 " + this.moveCnt + "입니다.");
        return this.moveCnt;
    }
}
