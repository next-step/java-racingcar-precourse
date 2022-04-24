package racingcar.rule;

@FunctionalInterface
public interface MoveRule {

    static MoveRule ofDefault() {
        return new DefaultMoveRule();
    }

    MoveRuleResult tryMove(Condition moveCondition);
}
