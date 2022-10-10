package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class CarNameTest {

    @Test
    void emptyCarNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarName emptyCarName = new CarName("");
        });
    }

    @Test
    void oversizeCarNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarName oversizedCarName = new CarName("yoordis");
        });
    }
}
