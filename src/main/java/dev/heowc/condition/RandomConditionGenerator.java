package dev.heowc.condition;

import java.util.concurrent.ThreadLocalRandom;

final class RandomConditionGenerator implements ConditionGenerator {
    @Override
    public Condition generate() {
        return Condition.of(ThreadLocalRandom.current().nextInt(Condition.MIN, Condition.MAX));
    }
}
