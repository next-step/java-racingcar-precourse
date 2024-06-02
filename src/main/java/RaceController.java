import java.util.Random;

public class RaceController {
    private final Race race;
    private final RaceView view;
    private final Random random;
    private final int tryCount;

    public RaceController(String[] carNames, int tryCount) {
        this.race = new Race(carNames);
        this.view = new RaceView();
        this.random = new Random();
        this.tryCount = tryCount;
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            race.moveCars(random);
            view.printPositions(race.getCars());
        }
        view.printWinners(race.findWinners());
    }
}
