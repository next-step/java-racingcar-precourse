package racinggame.domain;

import java.util.Objects;

public class StepCount {

    private int value;

    public StepCount(){
        this.value = 0;
    }

    public void addStep(){
        this.value += 1;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepCount stepCount = (StepCount) o;
        return value == stepCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
