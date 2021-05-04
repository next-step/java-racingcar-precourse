package me.ascii92der.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void carConstructorTest(){
        Cars cars = new Cars("KIA,BMW,AUDI");
        assertThat(cars.getCarGroup().size()).isEqualTo(3);
    }
}
