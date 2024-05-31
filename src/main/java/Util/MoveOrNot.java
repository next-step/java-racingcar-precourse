package Util;

import Model.Car;

public class MoveOrNot {
    private MoveOrNot(){

    }
    //4 ~ 9라면 전진이므로 true, 아니면 false 리턴
    public static void checkMoveOrNot(int randomNumber, Car car){
        if(randomNumber >= 3 && randomNumber <= 9){
            car.addCarMoveOnce();
        }
    }

}
