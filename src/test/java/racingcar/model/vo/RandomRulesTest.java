package racingcar.model.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.RandomRules;

public class RandomRulesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("랜덤숫자_생성")
    void makeRandom() {
        for (int i = 0; i < 10; i++) {
            RandomNumber randomNumber = new RandomNumber();
            System.out.println(randomNumber.getMoveNumber());
        }
    }
}
