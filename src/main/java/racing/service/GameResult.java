package racing.service;


import racing.vo.Car;
import racing.vo.Reception;

import java.util.Collections;
import java.util.StringJoiner;

public class GameResult {

    public GameResult(Reception reception) {
        gameWinner(reception);
    }

    public void gameWinner(Reception reception){
        Collections.sort(reception.getParticipants());
        int winnerPosition = reception.getParticipants().get(0).getPosition();
        StringJoiner sj  = new StringJoiner(",");
        for(Car car:reception.getParticipants()){
            sj.add(findWinner(winnerPosition,car));
        }
        System.out.println(sj +"가 최종 우승했습니다.");
    }

    private String findWinner(int winnerPosition,Car currentCar){
        if(winnerPosition==currentCar.getPosition()){
            return currentCar.getCarName();
        }
        return "";
    }
}
