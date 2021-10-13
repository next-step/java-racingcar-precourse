package racinggame;

public enum Boundary {
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
}
