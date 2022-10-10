package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private final Racing racing = new Racing();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void 경주_시작(String inputNames, String inputCount){
        InputStream in = createInputStream(inputNames, inputCount);
        System.setIn(in);
        new Scanner(System.in);
        try { racing.start(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("최종 우승자");
    }

    private static Stream<Arguments> provideInput(){
        return Stream.of(
                Arguments.of("pobi,honux,crong\n", "5\n")
                );
    }

    private InputStream createInputStream(String inputNames, String inputCount){
        List<InputStream> streams = Arrays.asList(
                new ByteArrayInputStream(inputNames.getBytes()),
                new ByteArrayInputStream(inputCount.getBytes())
        );
        return new SequenceInputStream(Collections.enumeration(streams));
    }
}
