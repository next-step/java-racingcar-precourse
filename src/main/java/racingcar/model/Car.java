package racingcar.model;

public class Car {
    private String name;
    private int movingDistance;

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoveCount(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void movingForward(int distance){
        this.movingDistance = this.movingDistance + distance;
    }
}
