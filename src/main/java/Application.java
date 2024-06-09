import model.RaceManager;

public class Application {

    public static void main(String[] args) {
        RaceManager rm = new RaceManager();
        rm.raceSetup();
        rm.doRace();
    }

}
