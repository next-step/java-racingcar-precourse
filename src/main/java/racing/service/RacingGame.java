package racing.service;

import racing.vo.Car;
import racing.vo.Racing;

public class RacingGame{

    private Racing racing;

    public RacingGame(Racing racing) {
        this.racing = racing;
    }

    public void startRound() {
        for (int i = 0; i < racing.gameRound(); i++) {
            moveCar();
        }
    }

    private void moveCar() {
        for (Car car : racing.gamePlayers()) {
            car.randomSetPosition();
            System.out.println(distancePrint(car));
        }
        System.out.println();
    }

    public String distancePrint(Car car){
        return car.getCarName() + ":\t" + car.getPositionText();
    }

}
