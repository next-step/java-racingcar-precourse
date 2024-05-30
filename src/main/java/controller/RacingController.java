package controller;

import model.Car;
import view.RacingView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingController {
    private int tryNum;
    private List<Car> carlist ;

    public RacingController(){
        tryNum = 0;
    }
    public void addCarlist(String[] carNames){
        for(String carname : carNames){
            Car car = new Car(carname);
            carlist.add(car);
        }

    }

    public void inputCarName(){
        String inputCars = RacingView.printInputCarName();
        String[] carNames = inputCars.split(",");

    }
    public void inputTryNum(){
        tryNum = RacingView.printInputTryNum();
    }

}
