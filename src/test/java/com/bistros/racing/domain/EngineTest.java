package com.bistros.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EngineTest {


    @Test
    @DisplayName("파워가 " + Engine.MIN_POWER + " 이상 이동 가능하다")
    void when_power_greater_then_4_true() {
        Engine engine = new Engine();
        assertAll(
            () -> assertThat(engine.canMove(4)).isTrue(),
            () -> assertThat(engine.canMove(5)).isTrue(),
            () -> assertThat(engine.canMove(6)).isTrue(),
            () -> assertThat(engine.canMove(7)).isTrue(),
            () -> assertThat(engine.canMove(8)).isTrue(),
            () -> assertThat(engine.canMove(9)).isTrue()
        );
    }

    @Test
    @DisplayName("파워가 " + Engine.MIN_POWER + " 미만이면 이동 불가능하다")
    void when_power_below_3_then_false() {
        Engine engine = new Engine();
        assertAll(
            () -> assertThat(engine.canMove(0)).isFalse(),
            () -> assertThat(engine.canMove(1)).isFalse(),
            () -> assertThat(engine.canMove(2)).isFalse(),
            () -> assertThat(engine.canMove(3)).isFalse()
        );
    }
}