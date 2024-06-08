package com.ktc2.precourse.racingcar.converter;

import static org.junit.jupiter.api.Assertions.*;

import com.ktc2.precourse.racingcar.model.RacingCar;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerListConverterTest {

    Converter<List<RacingCar>, List<String>> converter;

    @BeforeEach
    void setUp() {
        converter = new WinnerListConverter();
    }

    @Test
    @DisplayName("자동차 목록을 우승자 목록으로 변환이 잘 되는지 테스트(케이스 1)")
    void convertTestCase1() {
        List<String> expected = Stream.of("efgh", "abcd")
            .sorted()
            .toList();

        List<String> actual = converter.convertOrThrow(List.of(
            new RacingCar("aa", 3),
            new RacingCar("abcd", 5),
            new RacingCar("bb", 2),
            new RacingCar("efgh", 5),
            new RacingCar("cc", 1)))
            .stream()
            .sorted()
            .toList();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 목록을 우승자 목록으로 변환이 잘 되는지 테스트(케이스 2)")
    void convertTestCase2() {
        List<String> expected = List.of("abcd");

        List<String> actual = converter.convertOrThrow(List.of(
                new RacingCar("aa", 3),
                new RacingCar("abcd", 7),
                new RacingCar("bb", 2),
                new RacingCar("cc", 6)))
            .stream()
            .sorted()
            .toList();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 목록을 우승자 목록으로 변환이 잘 되는지 테스트(케이스 3)")
    void convertTestCase3() {
        List<String> expected = Stream.of("abcd", "aa", "efgh", "bb")
            .sorted()
            .toList();

        List<String> actual = converter.convertOrThrow(List.of(
                new RacingCar("aa", 3),
                new RacingCar("abcd", 3),
                new RacingCar("bb", 3),
                new RacingCar("cc", 2),
                new RacingCar("efgh", 3)))
            .stream()
            .sorted()
            .toList();

        assertEquals(expected, actual);
    }
}