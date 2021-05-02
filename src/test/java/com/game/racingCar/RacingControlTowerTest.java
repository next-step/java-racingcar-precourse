package com.game.racingCar;

import com.game.global.exception.CarsException;
import com.game.global.code.CarsExceptionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class RacingControlTowerTest {

    @DisplayName("입력된 자동차명 중 비어 있는 경우")
    @Test
    public void checkEmptyCarNameTest() {
        // Given
        String csvCarListString = "pobi,crong,,honux";

        // When
        final CarsException exception = assertThrows(CarsException.class, () -> new RacingControlTower(csvCarListString));

        // Then
        assertEquals(CarsExceptionType.EMPTY_CAR_NAME, exception.getCarsExceptionType());
    }

    @DisplayName("입력된 자동차명 중 입력 길이를 초과한 경우")
    @Test
    public void checkOversizeCarNameTest() {
        // Given
        String csvCarListString = "pobi,crong,honux222";

        // When
        final CarsException exception = assertThrows(CarsException.class, () -> new RacingControlTower(csvCarListString));

        // Then
        assertEquals(CarsExceptionType.OVERSIZE_CAR_NAME, exception.getCarsExceptionType());
    }

    @DisplayName("입력된 자동차명 중 이름이 중복된 경우")
    @Test
    public void checkDuplicateCarNameTest() {
        // Given
        String csvCarListString = "pobi,crong,honux,pobi";

        // When
        final CarsException exception = assertThrows(CarsException.class, () -> new RacingControlTower(csvCarListString));

        // Then
        assertEquals(CarsExceptionType.DUPLICATE_CAR_NAME, exception.getCarsExceptionType());
    }

    @DisplayName("자동차 목록이 올바르게 완성된 경우")
    @Test
    public void checkCarsObjectIsRightTest() {
        // Given
        String csvCarListString = "pobi,crong,honux";
        final String[] splitCarArray = csvCarListString.split(",");

        // When
        final RacingControlTower racingControlTower = new RacingControlTower(csvCarListString);

        // Then
        final Map<String, RacingCar> statusMap = racingControlTower.getStatusMap();
        for (String carName : splitCarArray) {
            Assertions.assertTrue(statusMap.containsKey(carName));
        }
    }

}
