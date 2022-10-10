package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Racing {

    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;

    public void racing(){
        RacingSetting racingSetting = new RacingSetting();
        Cars cars = racingSetting.getCars();
        System.out.println("\n실행결과");
        for(int index=0;index<racingSetting.getRound();index++){
            racingProgress(cars);
        }
        RacingResult racingResult = new RacingResult(cars);
        racingResult.consoleOutWinningCars();
    }


    public void racingProgress(Cars cars){
        System.out.println();
        for(Car car : cars.getCarList()){
            car.getCarPosition().updatePosition(getRandomNumber());
            System.out.println(car.getCarName().getName() + " : " + car.getCarPosition().getPositionProgress());
        }
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM,MAX_RANDOM_NUM);
    }


}

