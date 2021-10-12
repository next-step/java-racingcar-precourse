package racinggame.domain;

import java.util.Objects;

public class Step implements Comparable<Step> {
    private static final String STEP_DASH = "-";
    private int num;

    public Step(int num) {
        this.num = num;
    }

    public void forward() {
        this.num++;
    }

    public Message makeStepMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(STEP_DASH);
        }

        return new Message(stringBuilder.toString());
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
