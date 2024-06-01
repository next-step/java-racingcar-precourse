package Util;

import Model.Car;

public class MoveOrNot {
    private MoveOrNot(){

    }
    // 4 ~ 9라면 전진이므로 Car객체에 전진상태와 전진횟수 증가
    public static void checkMoveOrNot(int randomNumber, Car car){
        if(randomNumber >= 4 && randomNumber <= 9){
            car.addCarMoveOnce();
        }
    }

}
