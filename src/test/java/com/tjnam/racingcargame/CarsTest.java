package com.tjnam.racingcargame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void initializeTest(){
        List<CarName> carNames = new ArrayList<CarName>();
        carNames.add(new CarName("Car1"));
        carNames.add(new CarName("Car2"));
        carNames.add(new CarName("Car3"));
        assertThat(carNames.size()).isEqualTo(3);
    }

}
