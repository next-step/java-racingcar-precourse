package racinggame;

public class Application {
    public static void main(String[] args) {
        String[] carNames = RaceUI.takeCarNameInputProcess();
        int iterationCount = RaceUI.takeIterationCountProcess();
        Race race = Race.of(carNames, iterationCount);
    }
}
