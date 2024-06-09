package controller;
import model.Car;

import java.util.*;

public class Controller {
    private Vector <String> carName;
    private int moveCnt;
    private Vector<Car> carList;

    public void play() { //자동차 경주 게임 전반의 흐름을 처리
        carName = EntryCarName.getCarName(); //사용자에게 입력받은 자동차 이름 저장
        moveCnt = EntryMoveCnt.getMoveCnt(); //사용자에게 입력받은 시도 횟수 저장
        carList=makeCar(carName); //자동차 객체 생성
        DecisionMove.decide(carList); //자동차들을 전진할지 멈출지 판단

    }

    public Vector<Car> makeCar(Vector<String> carName) { //car 객체를 생성하는 기능
        int numberOfCar = carName.size();
        Vector<Car> carList = new Vector<>();
        for(int  i = 0 ; i < numberOfCar ; i++){
            Car car = new Car(carName.get(i));
            carList.add(car);
        }
        return carList;
    }
}
