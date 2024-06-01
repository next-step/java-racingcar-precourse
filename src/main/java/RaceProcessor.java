import java.util.List;

public class RaceProcessor {

    private Output output = new Output();
    private Rule rule = new Rule();

    public void raceForCnt(List<Car> racingCars, int gameCnt) {
        for (int i = 0; i < gameCnt; i++) {
            for (Car car : racingCars) {
                rule.randomAdvanceOrStop(car);
            }
            output.resultOutput(racingCars);
        }
    }
}
