package racinggame.domain;

public class GoCount implements Comparable<GoCount> {
    private int goCount;

    public GoCount() {
        this.goCount = 0;
    }

    public int getGoCount() {
        return goCount;
    }

    public void setGoCount(int goCount) {
        this.goCount = goCount;
    }

    public boolean equals(GoCount compGoCount) {
        return goCount == compGoCount.getGoCount();
    }

    @Override
    public int compareTo(GoCount o) {
        return Integer.compare(goCount, o.getGoCount());
    }
}
