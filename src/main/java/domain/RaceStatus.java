package domain;

public enum RaceStatus {
    YET,
    END;

    public boolean isEnd() {
        return this.equals(RaceStatus.END);
    }
}
