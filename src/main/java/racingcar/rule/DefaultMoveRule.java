package racingcar.rule;

final class DefaultMoveRule implements MoveRule {

    private static final Condition CONDITION = Condition.of(4);

    @Override
    public MoveRuleResult tryMove(Condition condition) {
        final int value = CONDITION.compareTo(condition);
        if (value <= 0) {
            return MoveRuleResult.GO;
        }
        return MoveRuleResult.STOP;
    }
}
