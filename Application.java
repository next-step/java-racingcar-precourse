import java.io.IOException;
import java.util.concurrent.Callable;

public class Application {
    public static void main(String[] args) throws IOException {
        InputGetter inputGetter = new InputGetter();
        String[] userName = inputGetter.getUserName();
        int numberOfTry = inputGetter.getNumberOfTry();

        RaceGame raceGame = new RaceGame(userName);
        raceGame.doGame(numberOfTry);
    }
}
