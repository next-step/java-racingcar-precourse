package controller;

import domain.Car;
import domain.Racing;
import java.io.IOException;
import java.util.List;
import utils.Checker;
import view.RacingView;

public class RacingController {
    private final Racing racing;
    private final RacingView view;
    private final Checker checker;
    public RacingController(){
        racing=new Racing();
        view=new RacingView();
        checker=new Checker();
    }
    public void run(){
        boolean can=false;
        view.startRacing();
        while(!can){
            can=input();
        }
        int n=view.inputNumber();
        for(int i=0; i<n; i++){
            round();
        }
        System.out.println(view.createWinnerResult(getWinner()).toString());
    }
    public boolean input(){
        try{
            String names=view.inputNames();
            List<String> carNames=checker.checkCarName(names);
            racing.makeCars(carNames);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void round(){
        racing.round();
        System.out.println(racing.createRoundResult().toString());
    }
    public List<Car> getWinner(){
        int num=racing.findWinnerDistance(racing.getCarList());
        return racing.winnerCars(racing.getCarList(),num);
    }


}
