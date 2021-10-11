package racinggame;

public class RaceManager {
    private static RaceManager raceManager;
    private int currentCount;
    private final int gameEndCount;

    private RaceManager(int gameEndCount) {
        this.gameEndCount = gameEndCount;
    }

    public static RaceManager createInstance(int gameEndCount) {
        if (raceManager == null) {
            raceManager = new RaceManager(gameEndCount);
        }

        return raceManager;
    }

    public static RaceManager getInstance() {
        if (raceManager == null) {
            // exception 메시지
        }

        return raceManager;
    }

    public static void deleteInstance() {
        if (raceManager != null) {
            raceManager = null;
        }
    }

    public void process() {
        currentCount++;
    }

    public boolean isGameEnd() {
        return currentCount == gameEndCount;
    }
}
