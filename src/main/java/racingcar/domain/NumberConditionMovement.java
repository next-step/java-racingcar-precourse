package racingcar.domain;

public class NumberConditionMovement implements Movement {
    private static final int CONDITION = 4;
    private final NumberGenerator numberGenerator;

    private NumberConditionMovement(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static NumberConditionMovement from(NumberGenerator numberGenerator) {
        return new NumberConditionMovement(numberGenerator);
    }

    @Override
    public boolean forward() {
        return CONDITION <= numberGenerator.generate();
    }
}
