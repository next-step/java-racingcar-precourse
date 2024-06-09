package controller;

import java.util.*;

public class Result { //View가 출력할 것을 전달해주는 Result 객체
    private Vector<String> carName; //각 자동차의 이름이 담김
    private Vector<Integer> carMove; //각 자동차마다 얼만큼 움직여야 하는지 담는 벡터

    public Result (Vector<String> carName){
        this.carName = carName;
    }

    public void setCarMove(Vector<Integer> carMove){
        this.carMove = carMove;
    }

    public Vector<String>  getCarName(){
        return carName;
    }

    public Vector<Integer> getCarMove() {
        return carMove;
    }
}
