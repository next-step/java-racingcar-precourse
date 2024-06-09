package controller;
import model.Car;
import view.View;

import java.util.*;

public class Controller {
    private Vector <String> carName;
    private int moveCnt;
    private Vector<Car> carList;
    private Vector<String> winner;

    public void play() { //자동차 경주 게임 전반의 흐름을 처리
        carName = EntryCarName.getCarName(); //사용자에게 입력받은 자동차 이름 저장
        moveCnt = EntryMoveCnt.getMoveCnt(); //사용자에게 입력받은 시도 횟수 저장
        carList=makeCar(carName); //자동차 객체 생성

        View view = new View(); //뷰 생성

        for(int i = 0 ; i < moveCnt; i++){ //게임 진행
            DecisionMove.decide(carList); //자동차들을 전진할지 멈출지 판단
            view.print(carList);//사용자에게 게임 과정 출력
        }

        winner = DecisionWinner.decideWinner(carList); //우승자를 가림
        view.printWinner(winner); //우승자를 출력

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
