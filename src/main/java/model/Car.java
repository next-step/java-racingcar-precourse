package model;

public class Car {
    private String carName; //자동차 이름
    private boolean move; //전진할지 멈출지 담는 변수

    public Car(String carName){
        this.carName = carName;
        move = false;
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
}
