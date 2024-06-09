package model;

import java.util.Random;

public class Car {
    private String carName; //자동차 이름
    private int numberOfMove; // 얼마나 이동했는지 담는 변수
    private static final Random random = new Random();

    public Car(String carName){
        this.carName = carName;
        numberOfMove = 0;
    }

    public Car(int numberOfMove, String carName) {
        this.numberOfMove = numberOfMove;
        this.carName = carName;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }
    public void tryIncreaseNumberOfMove() { //랜덤값을 구해서 랜덤값이 4이상인경우 움직이는 함수
        int ramdomValue = random.nextInt(10);
        if (ramdomValue >= 4) {
            numberOfMove++;
        }
    }

    public String getCarName() {
        return carName;
    }

}
