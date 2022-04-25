package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<RacingCar> racingCars;
    private int round;

    private Race() {

    }

    private Race(List<String> carNames, int round) {
        createRaceCar(carNames);
        this.round = round;
    }

    public static Race getIntance(List<String> carNames, int round) {
        return new Race(carNames, round);

    }

    private void createRaceCar(List<String> carNames) {
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            this.racingCars.add(RacingCar.getNewInstance(carName));
        }
    }

    public void start(){
        System.out.println("실행 결과");
        for (int i = 0; i < this.round; i++) {
            this.getRacingCars().forEach(RacingCar::start);
            System.out.println("");
        }
    }

    private List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void printResult(){
        String printFormat = "최종 우승자는 %s 입니다.";
        System.out.println(String.format(printFormat, String.join(", ", getWinners())));
    }

    private List<String> getWinners(){
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : getRacingCars()) {
            if ( maxDistance() <= racingCar.getTotalDistance()){
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }

    private int maxDistance(){
        int maxDistance = 0;
        for (RacingCar racingCar : getRacingCars()) {
            if (maxDistance < racingCar.getTotalDistance()){
                maxDistance = racingCar.getTotalDistance();
            }
        }
        return maxDistance;
    }

}
