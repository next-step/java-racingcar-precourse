package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingGame {
    private int gameCount;
    private RacingCars racingCars;
    public RacingGame(String racingCarNameInput,String gameCountInput) {
        List<RacingCar> racingCars = new ArrayList<>();

        gameCount = Integer.parseInt(gameCountInput);
        String[] racingCarNames = racingCarNameInput.split(",");

        for(String racingCarName : racingCarNames){
            racingCars.add(new RacingCar(racingCarName));
        }

        this.racingCars = new RacingCars(racingCars);
    }

    public int getGameCount() {
        return gameCount;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public void runRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            racingCars.runEachRacingcCarRace();
            System.out.println();
        }
    }

    public void getRacingResult() {
        String winingRacingCar = "";
        racingCars.getRacingCars().sort(RacingCar::compareTo);
        winingRacingCar = racingCars.getRacingCars().get(0).getRacingCarName();

        for (int i = 1; i < racingCars.getRacingCars().size(); i++) {
            winingRacingCar = getSameWinningRacingCar(winingRacingCar, i);
        }

        System.out.println("최종 우승자 : " + winingRacingCar);
    }

    private String getSameWinningRacingCar(String winingRacingCar, int i) {
        if(racingCars.getRacingCars().get(0).getForwardCount() == racingCars.getRacingCars().get(i).getForwardCount()){
            winingRacingCar += ", "+racingCars.getRacingCars().get(i).getRacingCarName();
        }
        return winingRacingCar;
    }
}
