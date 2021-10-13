package racinggame;

public enum Boundary {
    NAME(1, 5),
    RANDOM_NUM(0, 9);

    private int minNum;
    private int maxNum;

    Boundary(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public boolean isWithinRange(int number) {
        if (this.minNum == -1 && this.maxNum == -1) {
            return false;
        }
        if (this.minNum != -1 && this.minNum > number) {
            return false;
        }
        return this.maxNum == -1 || this.maxNum >= number;
    }
}
