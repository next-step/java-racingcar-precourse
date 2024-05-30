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
    public void startRacing(){
        inputCarName();
        inputTryNum();
    }
    public void addCarlist(String[] carNames){
        carlist = new ArrayList<>();
        for(String carname : carNames){
            Car car = new Car(carname);
            carlist.add(car);
        }

    }

    public void inputCarName(){
        String inputCars = RacingView.printInputCarName();
        String[] carNames = inputCars.split(",");
        addCarlist(carNames);

    }
    public void inputTryNum(){
        tryNum = RacingView.printInputTryNum();
    }
    public void moveCarByRandNum(List<Car> cars){
        int randNum = (int)(Math.random()*9);
        for(int i =0;i<carlist.size();i++){
            cars.get(i).moveCar(randNum);
        }
    }

}
