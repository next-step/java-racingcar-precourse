package racinggame;

public class RaceCount {
    private int count;

    public RaceCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        validation();
        this.count = count;
    }

    private void validation(){
        if (count < 0 || count > 1000) {
            throw new IllegalArgumentException("레이스는 1000회 까지만 가능합니다.");
        }
    }
}
