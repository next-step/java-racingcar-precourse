import java.util.List;

public class GameProcessController {
    Track track;

    public void gameStart() throws Exception {
        inputNamePhasePhase();
    }

    private void inputNamePhasePhase() throws Exception {
        List<Car> cars = UserInterface.inputCars();
        track = new Track();
        track.addCars(cars);
        inputRaceConfigPhase();
    }

    private void inputRaceConfigPhase() throws Exception {
        int maxRaceCount = UserInterface.inputRaceCount();
        racePhase(maxRaceCount);
    }

    private void racePhase(int maxRaceCount) {
        int raceCount = 0;
        Printer.printRaceStart();
        while (raceCount++ < maxRaceCount) {
            race();
        }

    }

    private void race() {
        track.race();
        Printer.printTrackStatus(track);
    }

}
