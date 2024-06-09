package controller;

import model.Car;
import java.util.*;

public class DecisionWinner { //우승자를 판별하는 것과 관련된 클래스
    public static void decideWinner(Vector<Car> carList){
        int winnerMove = findWinnerMove(carList);
    }

    public static int findWinnerMove(Vector<Car> carList){ //우승자의 전진 횟수를 찾아주는 함수
        Vector<Integer> numberOfMove = new Vector<>(); //자동차들의 numberOfMove 변수를 담는 벡터 생성
        for (int i = 0; i < carList.size(); i++) { //자동차들의 numberOfMove 변수값들을 벡터에 저장
            numberOfMove.add(carList.get(i).getNumberOfMove());
        }
        Collections.sort(numberOfMove); //벡터 원소들 오름차순으로 정렬

        return numberOfMove.get(numberOfMove.size()-1); //벡터 맨 뒤에 있는 값이 우승자의 전진 횟수
    }
}
