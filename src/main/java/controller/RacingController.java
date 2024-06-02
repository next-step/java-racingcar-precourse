package controller;

import domain.Car;
import domain.Racing;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;
import javax.swing.text.View;
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
        boolean can=true;
        try{
            String names=view.inputNames();
            List<String> carNames=checker.checkCarName(names);
            racing.makeCars(carNames);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            can=false;
        }
        return can;
    }
    public void round(){
        racing.round();
        racing.createRoundResult();
    }
    public List<Car> getWinner(){
        int num=racing.findWinnerDistance(racing.getCarList());
        return racing.winnerCars(racing.getCarList(),num);
    }


}
