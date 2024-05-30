package controller;

import model.Car;
import utils.InputValidation;
import view.RacingView;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        RacingView.printResultmessage();
        for(int i = 0;i<tryNum;i++){
            moveCarByRandNum(carlist);
            RacingView.moveStatus(carlist);
        }

        RacingView.printResult(getWinner());
    }
    public void addCarlist(String[] carNames){
        carlist = new ArrayList<>();
        for(String carname : carNames){
            Car car = new Car(carname);
            carlist.add(car);
        }

    }

    public void inputCarName(){
        while(true){
            try{
                String inputCars = RacingView.printInputCarName();
                String[] carNames = inputCars.split(",");

                InputValidation.isValidInput(carNames);//유효성검사

                addCarlist(carNames);
                break;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }

        }


    }
    public void inputTryNum(){
        while(true){
            try{
                String inputTryNum = RacingView.printInputTryNum();
                InputValidation.isNumber(inputTryNum); //정수인지 확인
                tryNum = Integer.parseInt(inputTryNum);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]"+e.getMessage());
            }

        }

    }
    public void moveCarByRandNum(List<Car> cars){

        for(int i =0;i<carlist.size();i++){
            int randNum = (int)(Math.random()*9);
            cars.get(i).moveCar(randNum);
        }
    }
    public List<Car> getWinner(){
        int maxMove = getMaxMove();
        return carlist.stream()
                .filter(car->car.getMove() == maxMove)
                .toList();

    }
    public int getMaxMove(){
        return carlist.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    public List<Car> getCarlist(){
        return carlist;
    }

}
