package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private final CarFactory carFactory = new CarFactory();

    @Test
    @DisplayName("Valid Split By Comma")
    void validateSplitByComma() {
        // When
        String name = "Bell, Sonny, Kane";

        // Then
        List<String> result = carFactory.splitByComma(name);

        // Then
        assertThat(result).containsExactly("Bell", "Sonny", "Kane");
    }

    @Test
    @DisplayName("Create cars from list of names")
    void createCars() {
        // Given
        List<String> carsNames = List.of("Bell", "Sonny", "Kane");

        // When
        List<Car> carsList = carFactory.createCars(carsNames);

        // Then
        assertThat(carsList).hasSize(3);
        assertThat(carsList).extracting(Car::getName).containsExactly("Bell", "Sonny", "Kane");
    }
}