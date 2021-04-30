package homework.racegame.domain;

import java.util.Random;

public class Car {

    private final int GO_STOP_BOUNDARY = 4;
    private final String name;
    private final StringBuffer progress;

    public Car(String name) {
        this.name = name;
        this.progress = new StringBuffer();
    }

    public Car(String name, StringBuffer progress) {
        this.name = name;
        this.progress = progress;
    }

    String getMoveProgress() {
        return this.progress.toString();
    }

    int getMoveProgressValue() {
        return this.progress.length();
    }

    boolean isPossibleToMove() {
        return new Random().nextInt(10) >= GO_STOP_BOUNDARY;
    }

    void move() {
        this.progress.append("-");
    }

    void printMoveProgress() {
        System.out.println(new StringBuffer(name).append(":").append(getMoveProgress()));
    }

    public void moveOrStop() {
        if (isPossibleToMove()) {
            move();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name: ").append(name).append(", progress: ").append(progress);
        return stringBuffer.toString();
    }
}
