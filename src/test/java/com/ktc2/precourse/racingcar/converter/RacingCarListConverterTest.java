package com.ktc2.precourse.racingcar.converter;

import com.ktc2.precourse.racingcar.exception.ContainsWhiteSpaceToCarNameException;
import com.ktc2.precourse.racingcar.exception.InvalidCarNameLengthException;
import com.ktc2.precourse.racingcar.model.DtoRacingCarList;
import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarListConverterTest {

    Converter<String, DtoRacingCarList> converter;

    @BeforeEach
    void setUp() {
        converter = new RacingCarListConverter();
    }

    @Test
    @DisplayName("올바른 케이스에 대해 변환이 잘 되는지 여부 테스트")
    void validStringTest() {
        assertEquals(new DtoRacingCarList(List.of(
            new RacingCar("abc"),
            new RacingCar("def"),
            new RacingCar("1"),
            new RacingCar("Ab.DC"),
            new RacingCar("10201"),
            new RacingCar("k"))),
            converter.convertOrThrow("    abc,def   ,1  ,Ab.DC,10201,   k"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        "abcedf",
        "a,bcd,w,",
        "aaaa,bbbbbbb,cc",
        "abc,,def"})
    @DisplayName("길이 조건을 만족하지 않은 자동차 이름이 있으면 예외가 발생하는지 테스트")
    void invalidNameLengthTest(String input) {
        assertThrows(InvalidCarNameLengthException.class, () -> converter.convertOrThrow(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "a   b",
        "ab df",
        "a ,b cd,w",
        "aaa a,bbb,cc",
        "abc,d  ef"})
    @DisplayName("공백이 들어간 자동차 이름이 있으면 예외가 발생하는지 테스트")
    void containsWhiteSpaceTest(String input) {
        assertThrows(ContainsWhiteSpaceToCarNameException.class, () -> converter.convertOrThrow(input));
    }
}