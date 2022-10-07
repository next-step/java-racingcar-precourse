package racingcar.model;

public class Rule {
    private final int count;

    public Rule(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if(count <= 0) throw new IllegalArgumentException("[ERROR] counts must be positive number");
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "count=" + count +
                '}';
    }
}
