package model;

import java.util.Random;

public class Car {
    private String carName; //자동차 이름
    private int numberOfMove; //지금까지 얼마나 이동했는지 담는 변수
    private static final Random random = new Random();

    public Car(String carName){
        this.carName = carName;
        numberOfMove = 0;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }
    public void tryIncreaseNumberOfMove() {
        int ramdomValue = random.nextInt(10);
        if (ramdomValue >= 4) {
            numberOfMove++;
        }
    }


    public String getCarName() {
        return carName;
    }

}
