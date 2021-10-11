package racinggame.domain;

import java.util.Objects;

public class Step implements Comparable<Step> {
    private int num;

    public Step(int num) {
        this.num = num;
    }

    public void forward() {
        this.num++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Step)) {
            return false;
        }
        Step step = (Step)o;
        return num == step.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public int compareTo(Step o) {
        return Integer.compare(this.num, o.num);
    }
}
