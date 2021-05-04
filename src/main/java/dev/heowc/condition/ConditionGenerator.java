package dev.heowc.condition;

public interface ConditionGenerator {

    static ConditionGenerator random() {
        return new RandomConditionGenerator();
    }

    Condition generate();
}
