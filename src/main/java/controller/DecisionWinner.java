package controller;

import model.Car;
import java.util.*;

public class DecisionWinner { //우승자를 판별하는 것과 관련된 클래스
    public static Vector<String> decideWinner(Vector<Car> carList){ //우승자를 판별하는 기능
        int winnerMove = findWinnerMove(carList); //우승자의 전진 횟수를 구함
        Vector<String> winner = new Vector<>(); //우승자들의 자동차 이름을 담을 벡터
        for(int i = 0; i < carList.size(); i++){
            Car car = carList.get(i);
            if (car.getNumberOfMove() == winnerMove)
                winner.add(car.getCarName()); // 우승자들의 이름을 벡터에 추가
        }

        return winner;
    }

    private static int findWinnerMove(Vector<Car> carList){ //우승자의 전진 횟수를 찾아주는 함수
        Vector<Integer> numberOfMove = new Vector<>(); //자동차들의 numberOfMove 변수를 담는 벡터 생성
        for (int i = 0; i < carList.size(); i++) { //자동차들의 numberOfMove 변수값들을 벡터에 저장
            numberOfMove.add(carList.get(i).getNumberOfMove());
        }
        Collections.sort(numberOfMove); //벡터 원소들 오름차순으로 정렬

        return numberOfMove.get(numberOfMove.size()-1); //벡터 맨 뒤에 있는 값이 우승자의 전진 횟수
    }
}
