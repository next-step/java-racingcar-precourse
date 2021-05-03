package me.ascii92der.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    void carNameValidTest() {
        String name = "HYUNDAI";
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자까지만 가능합니다.");
    }

    @Test
    void carNameLengthTest() {
        String name = "BMW";
        CarName carName = new CarName(name);
        assertThat(carName.getName().length()).isEqualTo(name.length());
    }

    @Test
    void carNameSetTest() {
        String name = "AUDI";
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }
}
