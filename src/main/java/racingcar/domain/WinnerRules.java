package racingcar.domain;

public enum WinnerRules implements WinnerRule {
    HIGHEST_POSITION {
        @Override
        public Cars winner(final Cars cars) {
            Position highestPosition = cars.highestPosition();
            cars.equalPosition(highestPosition);
            return null;
        }
    }
}
