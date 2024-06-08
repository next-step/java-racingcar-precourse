package service;

import model.RacingCar;
import util.RandomNumberGenerator;
import view.CarRacingView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private final CarRacingView carRacingView = new CarRacingView();
    private static final String RESULT_MSG = "\n실행 결과";

    public void playRacingGame(ArrayList<RacingCar> racingCars, int attempt){
        System.out.println(RESULT_MSG);

        for(int i = 0; i < attempt; i++){
            moveCar(racingCars);
            carRacingView.displayRacingCars(racingCars);
        }
        carRacingView.displayWinners(findWinners(racingCars));
    }

    private void moveCar(ArrayList<RacingCar> racingCars){
        for (RacingCar car : racingCars) {
            int newPosition = car.getPosition() + RandomNumberGenerator.generateRandNum();
            car.setPosition(newPosition);
        }
    }

    private String[] findWinners(ArrayList<RacingCar> racingCars) {

        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        List<String> winnerList = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList.toArray(new String[0]);
    }
}
