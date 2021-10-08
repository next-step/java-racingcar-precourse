/*
 * CarNameTest
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.exception.IncorrectInputException;
import racinggame.utils.CarName;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarNameTest {
    @Test
    public void 자동차_이름_입력() throws Exception {
        String name = "이름";
        CarName carName = new CarName(name);
        assertThat(carName.get()).isNotNull().isEqualTo(name);
    }

    @Test
    public void 자동차_이름_입력_범위초과() throws Exception {
        assertThrows(IncorrectInputException.class, () -> new CarName(null));
        assertThrows(IncorrectInputException.class, () -> new CarName("123456"));
        assertThrows(IncorrectInputException.class, () -> new CarName("abcdef"));
        assertThrows(IncorrectInputException.class, () -> new CarName(""));
        assertThrows(IncorrectInputException.class, () -> new CarName("한글여섯글자"));
    }

}
