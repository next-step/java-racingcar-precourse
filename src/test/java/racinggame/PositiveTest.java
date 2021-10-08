/*
 * PositiveTest
 * java-racingcar-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.constants.UtilsConstant;
import racinggame.exception.IncorrectInputException;
import racinggame.utils.Positive;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void 정상_문자열입력_생성() throws Exception {
        String string = "123";
        Positive positive = new Positive(string);
        assertThat(positive.get()).isEqualTo(Integer.parseInt(string));
    }

    @Test
    public void 비정상_문자열() throws Exception {
        assertThat("1234".matches(UtilsConstant.ONLY_NUMBER_VALIDATE_REGEX)).isTrue();
        assertThat("ㄱㄴㄷ".matches(UtilsConstant.ONLY_NUMBER_VALIDATE_REGEX)).isFalse();
        assertThat("".matches(UtilsConstant.ONLY_NUMBER_VALIDATE_REGEX)).isFalse();
    }

    @Test
    public void 비정상_문자열입력_생성() throws Exception {
        assertThat(assertThrows(IncorrectInputException.class, () -> new Positive("ㄱㄴㄷ")).getMessage()).contains("[ERROR]");
        assertThat(assertThrows(IncorrectInputException.class, () -> new Positive("")).getMessage()).contains("[ERROR]");
        assertThat(assertThrows(IncorrectInputException.class, () -> new Positive(null)).getMessage()).contains("[ERROR]");
    }
}
