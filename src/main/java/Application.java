import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.getCarNames();
        int trialCount = inputHandler.getTrialCount();

        Race race = new Race(carNames);
        race.start(trialCount);

    }


}
