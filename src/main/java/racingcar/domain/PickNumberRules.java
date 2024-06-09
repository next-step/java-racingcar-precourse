package racingcar.domain;

import java.security.SecureRandom;

public enum PickNumberRules implements PickNumberRule {
    RANDOM {
        SecureRandom random = new SecureRandom();

        @Override
        public int pick() {
            return random.nextInt(10);
        }
    }
}
