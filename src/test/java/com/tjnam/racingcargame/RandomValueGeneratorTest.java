package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomValueGeneratorTest {

    private static RandomValueGenerator randomValueGenerator;

    @BeforeAll
    public static void setUp(){
        randomValueGenerator = new RandomValueGenerator();
    }

    @Test
    public void getValueTest(){
        for (int i=0 ; i < 1000 ; i++) {
            assertThat(randomValueGenerator.getValue()).isGreaterThan(0).isLessThan(10);
        }
    }
}
