package com.bistros.racing.game;

import com.bistros.racing.domain.Car;
import com.bistros.racing.exception.InvalidUserInputDataException;
import com.bistros.racing.exception.NotAllowCarNamePolicyException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void when_user_input_names_then_success() {
        String carNames = "pika,weka";
        Set<Car> cars = CarFactory.generateCars(carNames);
        assertAll(
            () -> assertThat(cars.size()).isEqualTo(2),
            () -> assertThat(cars.contains(new Car("pika"))),
            () -> assertThat(cars.contains(new Car("weka")))
        );
    }

    @Test
    void when_user_input_long_name_then_throw_exception() {
        String carNames = "pika,wekachue";
        assertThrows(NotAllowCarNamePolicyException.class,
            () -> CarFactory.generateCars(carNames));
    }

    @Test
    void when_user_input_null_data_then_throw_exception() {
        String carNames = "";
        assertThrows(InvalidUserInputDataException.class,
            () -> CarFactory.generateCars(carNames));
    }

}