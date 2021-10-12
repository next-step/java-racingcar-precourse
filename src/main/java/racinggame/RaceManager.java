package racinggame;

public class RaceManager {
    private static RaceManager raceManager;
    private RaceManagerCurrentCount raceManagerCurrentCount;
    private RaceManagerGameEndCount raceManagerGameEndCount;

    private RaceManager(String gameEndCount) {
        this.raceManagerCurrentCount = new RaceManagerCurrentCount(0);
        this.raceManagerGameEndCount = new RaceManagerGameEndCount(gameEndCount);
    }

    public int getGameEndCount() {
        return raceManagerGameEndCount.getGameEndCount();
    }

    public static RaceManager createInstance(String gameEndCount) {
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
        raceManagerCurrentCount.increaseCount();
    }

    public boolean isGameEnd() {
        return raceManagerCurrentCount.getCurrentCount() == raceManagerGameEndCount.getGameEndCount();
    }
}
