package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    public static final String FINAL_WINNER = "최종 우승자 :";
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }


    public void display() {
        racingCars
                .forEach(RacingCar::display);
    }

    public static List<RacingCar> makeNamedCars(List<String> racingCarNames) {
        ArrayList<RacingCar> cars = new ArrayList<>();
        for (String racingCarName : racingCarNames) {
            cars.add(new RacingCar(racingCarName));
        }
        return cars;
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.playGame();
        }
    }
    public void displayWinner(List<String> winnerNames){
        System.out.print(FINAL_WINNER + " ");
        System.out.print(String.join(",",winnerNames));
    }
    public List<String> calculateWinner() {
        int maxForward = -1;
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            maxForward = changeMaxForward(winnerNames,racingCar,maxForward);
        }
        return winnerNames;
    }

    private static int changeMaxForward(List<String> winnerNames, RacingCar racingCar,int maxForward) {
        if(maxForward == racingCar.getForward()){
            winnerNames.add(racingCar.getCarName());
        }
        if(maxForward < racingCar.getForward()) {
            winnerNames.clear();
            winnerNames.add(racingCar.getCarName());
            return racingCar.getForward();
        }
        return maxForward;
    }

    public void playGames(int gameCount){
        System.out.println("실행 결과");
        for (int c=0;c<gameCount;c++){
            playGame();
            display();
        }
    }
}
