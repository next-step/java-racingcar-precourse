package racingcar.model.primitive;

public class LapInfo {
    private String lapInfo;

    public LapInfo(String lapInfo) {
        this.lapInfo = lapInfo;
    }

    public String getLapInfo() {
        return lapInfo;
    }

    public void addLap() {
        lapInfo += "-";
    }
}
