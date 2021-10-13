package racinggame;

public enum ActStatus {
    STOP("", 0, 3),
    GO("-", 4, 9),
    Empty("", -1 ,-1);

    private String actExpress;
    private int minNum;
    private int maxNum;

    ActStatus(String actExpress, int minNum, int maxNum) {
        this.actExpress = actExpress;
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public static ActStatus findByActNumber(int number) {
        for (ActStatus actStatus :ActStatus.values()) {
            if (isWithinRange(actStatus, number)) {
                return actStatus;
            }
        }
        return Empty;
    }

    private static boolean isWithinRange(ActStatus actStatus, int number) {
        if(actStatus == Empty) {
            return false;
        }
        if (actStatus.minNum == -1 && actStatus.maxNum == -1) {
            return false;
        }
        if (actStatus.minNum != -1 && actStatus.minNum > number) {
            return false;
        }
        return actStatus.maxNum == -1 || actStatus.maxNum >= number;
    }

    public boolean doGo() {
        return this == GO;
    }
}
