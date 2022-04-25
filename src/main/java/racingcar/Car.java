package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveCount;
    private int maxMoveCount;
    private CarStatus status;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
        this.status = CarStatus.READY;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public CarStatus getStatus() {
        return this.status;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    public void go() {
        this.setStatus(CarStatus.GO);
    }

    public void stop() {
        this.setStatus(CarStatus.STOP);
    }

    public int getMaxMoveCount() {
        return this.maxMoveCount;
    }

    private void setStatus(CarStatus status) {
        this.status = status;
        this.moveCount = this.moveCount + status.getMoveCount();

        if (this.moveCount >= this.maxMoveCount) {
            this.status = CarStatus.FINISHED;
        }
    }

    public void move() {
        CarStatus carStatus = null;
        int randomNumber = this.makeRandomNumber();

        if (randomNumber > 3) {
            carStatus = CarStatus.GO;
        }

        if (randomNumber <= 3) {
            carStatus = CarStatus.STOP;
        }

        this.setStatus(carStatus);
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkStatusFinished() {
        return CarStatus.FINISHED == this.status;
    }

    public String printMoveCount() {
        StringBuilder stringBuilder = new StringBuilder(this.name + " : ");
        for (int i = 0; i < this.moveCount; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
