/*
 * PositiveTest
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.exception.IncorrectInputException;
import racinggame.utils.Positive;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveTest {

    @Test
    public void 입력받을_정수처리() throws Exception {
        //given
        Positive positive = new Positive(0);
        //when
        positive.plus();
        //then
        assertThat(positive.get()).isEqualTo(1);
    }

    @Test
    public void 입력범위_초과() throws Exception {
        assertThat(assertThrows(IncorrectInputException.class, () -> new Positive(-1)).getMessage()).contains("[ERROR]");
        assertThat(assertThrows(IncorrectInputException.class, () -> new Positive(10)).getMessage()).contains("[ERROR]");
    }
}
