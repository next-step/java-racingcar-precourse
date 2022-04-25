package racingcar.model;

import org.junit.jupiter.api.Test;

public class CarsFactoryTest {
    @Test
    void name() {
        CarsFactory.create("a,b");
    }
}
