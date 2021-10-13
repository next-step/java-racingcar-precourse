package racinggame.model;

import nextstep.utils.Randoms;

public class RacingCar{
    private String carName;
    private int currentMove;

    public RacingCar() {
    }

    public String getCarName(){
        return this.carName;
    }

    public void setCarName(String inputCarName){
        this.carName = inputCarName;
    }
    
    public void setCurrentMove(){
        this.currentMove = getRandomMove();
    }

    public int getCurrentMove(){
        return this.currentMove;
    }

    private int getRandomMove(){
        int move = Randoms.pickNumberInRange(0,9);
        return move;
    }
}