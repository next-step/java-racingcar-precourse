package racingcar.controller;

import racingcar.model.*;
import racingcar.view.GameResult;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private int numberOfPlay;
    private int numberOfMovement;
    private Position maxPosition;
    private final MovingStrategy movingStrategy;

    public GamePlayer(int number){
        this.numberOfPlay = number;
        this.maxPosition = new Position(0);
        movingStrategy = new RandomMoveStrategy();
    }

    public Cars play(Cars cars){
        while( ! isGameOver() ){
            numberOfMovement += 1;
            List<Position> move = cars.move(movingStrategy);
            updateMaxPosition(move);
        }

        return cars;
    }
    public Position getMaxPosition() {
        return maxPosition;
    }

    private void updateMaxPosition(List<Position> positionList){
        int max = 0;
        for(Position position : positionList){
            max = Math.max(this.maxPosition.getPosition(), position.getPosition());
            this.maxPosition = new Position(max);
        }
    }
    private boolean isGameOver(){
        if( numberOfMovement < numberOfPlay ) return false;
        return true;
    }
    public GameResult findWinnerNames(Cars cars){
        List<Name> list = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            Car car = cars.getCar(i);
            if(isWinner(car)){
                list.add(car.getName());
            }
        }
        return new GameResult(list);
    }

    public boolean isWinner(Car car){
        return car.getPosition().equals(maxPosition);
    }

    public String racingProgress(Cars cars){
        StringBuffer sb = new StringBuffer();
        sb.append("각 차수별 실행 결과\n");
        for(int i=0; i<cars.size(); i++){
            Car car = cars.getCar(i);
            sb.append(progressBarWithName(car));
            sb.append("\n");
        }
        return sb.toString();
    }
    private String progressBarWithName(Car car){
        return car.getName() + " : " + getProgressbar(car.getPosition());
    }

    private String getProgressbar(Position position) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i< position.getPosition(); i++){
            sb.append("-");
        }
        return sb.toString();
    }

}
