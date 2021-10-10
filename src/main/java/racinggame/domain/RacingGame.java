package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final CarList carList;
    private final CarList winners;
    private final RoundCount round;   // 회차,
    private StepCount headStep;       // 현재 선두의 Step


    // Ex, pobi,crong,honux
    public RacingGame(String cars, int round){
        this.carList = new CarList(cars);
        this.winners = new CarList();
        this.round = new RoundCount(round);
        this.headStep = new StepCount();
    }

    public StepCount getHeadStep(){
        for (Car car : carList.getCarList()){
            this.headStep.setValue(Math.max(this.headStep.getValue(), car.getStep().getValue()));
        }
        return this.headStep;
    }

    private void checkWinner(Car car){
        this.headStep = this.getHeadStep();
        if (this.headStep.equals(car.getStep())){
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
        for (int i = 0; i < round.getValue(); i++){
            this.move();
        }
        this.endGame();
    }


}
