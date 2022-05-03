package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.util.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCarList = new LinkedList<>();
    private RacingCars racingCars = new RacingCars();

    public RacingGame(){
    }

    public void playGame(){
        Game game = new Game();
        game.printInputCarNamesMessege();
        String[] carNameList = game.inputRacingCarName();
        game.checkIllegalCarNameInputs(carNameList);
        for(int idx = 0; idx < carNameList.length; idx++){
            RacingCar racingCar = new RacingCar(carNameList[idx]);
            racingCars.addCar(racingCar);
            System.out.println(carNameList[idx]);
        }
        System.out.println("반복 횟수를 입력하세요.");
        int repeatCount = game.inputRepeatCount();
        while(repeatCount > 0){
            for(int idx=0; idx<carNameList.length;idx++) {
                int randomNumber = RandomNumberGenerator.generateRandomNumber();
                racingCars.returnRacingCarAtIndex(idx).moveCarOrNot(randomNumber);
            }
            game.printEachRacingCarsPosition(racingCars);
            repeatCount--;
        }

        game.printWinners(game.getWinners(racingCars));
    }
}
