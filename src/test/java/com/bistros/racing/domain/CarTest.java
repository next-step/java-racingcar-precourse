package com.bistros.racing.domain;

import com.bistros.racing.exception.NotAllowCarNamePolicyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    @Test
    @DisplayName("자동차이름은 빈칸이거나 5글자를 초과 할 수 없다")
    void when_create_new_car_with_normal_name_then_success() {
        String expectName = "deal";
        Car car = new Car(expectName);
        assertThat(car.getName()).isEqualTo(expectName);
    }

    @Test
    @DisplayName("자동차 이름이 빈칸이거나 5글자를 초과하면 에러가 발생한다.")
    void when_invalid_use_carname_throw_exception() {
        assertAll(
            () -> assertThrows(NotAllowCarNamePolicyException.class, () -> new Car("")),
            () -> assertThrows(NotAllowCarNamePolicyException.class, () -> new Car("abcdef"))
        );
    }

}