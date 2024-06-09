package racingcar.domain;

public enum ForwardRules implements ForwardRule {
    MORE_THAN_FOUR {
        @Override
        public boolean isForward(final int number) {
            return number >= 4;
        }
    }
}
