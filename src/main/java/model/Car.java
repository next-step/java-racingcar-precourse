package model;

public class Car {
    private String carName; //자동차 이름
    private boolean move; //전진할지 멈출지 담는 변수
    private boolean randomValue; //random값 저장. 4이상인 경우 전진

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isRandomValue() {
        return randomValue;
    }

    public void setRandomValue(boolean randomValue) {
        this.randomValue = randomValue;
    }
}
