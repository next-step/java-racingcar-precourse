package racinggame.domain;

public enum CarStatus {
    GO, STOP;

    public boolean isGoForward() {
        return this == CarStatus.GO;
    }
}
