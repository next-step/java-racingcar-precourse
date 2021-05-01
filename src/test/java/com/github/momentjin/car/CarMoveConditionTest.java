package com.github.momentjin.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveConditionTest {

    @DisplayName("numberGenerator에서 정수 4~9를 반환하면 Car는 움직일 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movableToForward(int randomNumber) {

        // given
        NumberGenerator numberGenerator = new MockNumberGenerator(randomNumber);
        CarMoveCondition carMoveCondition = new CarMoveCondition(numberGenerator);

        // when
        boolean movable = carMoveCondition.movableToForward();

        // then
        assertThat(movable).isTrue();
    }

    @DisplayName("numberGenerator에서 정수 0~3을 반환하면 Car는 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void movableToForward2(int randomNumber) {

        // given
        NumberGenerator numberGenerator = new MockNumberGenerator(randomNumber);
        CarMoveCondition carMoveCondition = new CarMoveCondition(numberGenerator);

        // when
        boolean movable = carMoveCondition.movableToForward();

        // then
        assertThat(movable).isFalse();
    }
}

class MockNumberGenerator implements NumberGenerator {

    public int value;

    public MockNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}