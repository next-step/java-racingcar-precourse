package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final CarList carList;
    private final CarList winners;
    private final int count;          // 회차,
    private int maxStep;              // 현재 선두의 Step


    // Ex, pobi,crong,honux
    public RacingGame(String cars, int count){
        this.carList = new CarList(cars);
        this.winners = new CarList();
        this.count = count;
        this.maxStep = 0;
    }

    public int getMaxStep(){
        for (Car car : carList.getCarList()){
            this.maxStep = Math.max(this.maxStep, car.getCurrentStep());
        }
        return this.maxStep;
    }

    private void checkWinner(Car car){
        this.maxStep = this.getMaxStep();
        if (car.getCurrentStep() == this.maxStep){
            this.winners.addCar(car);
        }
    }

    public void endGame(){
        for (Car car : carList.getCarList()){
            checkWinner(car);
        }

        List<String> carNameList = new ArrayList<>();
        for (Car car : this.winners.getCarList()){
            carNameList.add(car.getName());
        }
        System.out.println("최종 우승자는 " + String.join(",", carNameList) +" 입니다.");
    }

    private void move(){
        for (Car car : carList.getCarList()){
            car.moveStep();
            car.printCurrentStep();
        }
        System.out.println();
    }

    public void play(){
        for (int i = 0;i < count; i++){
            this.move();
        }
        this.endGame();
    }


}
