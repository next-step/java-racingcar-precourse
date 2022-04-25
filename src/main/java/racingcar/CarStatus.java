package racingcar;

public enum CarStatus {
    READY("READY", "대기", 0),
    GO("GO", "전진", 1),
    STOP("STOP", "멈춤", 0),
    FINISHED("FINISHED", "도착", 0);

    private String code;
    private String label;
    private int moveCount;

    CarStatus(String code, String label, int moveCount) {
        this.code = code;
        this.label = label;
        this.moveCount = moveCount;
    }

    public String getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
