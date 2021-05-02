package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {
    private static CarName carName;

    @Test
    public void getCarNameTest(){
        String testedCarName = "TestedCarName";
        carName = new CarName(testedCarName);
        assertThat(carName.getName()).isEqualTo(testedCarName);
    }
}
