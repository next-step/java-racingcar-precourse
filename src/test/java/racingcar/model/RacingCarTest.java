package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    final String ERROR = "[ERROR]";
    String[] validCars = {"iron", "man", "black", "widow"};
    String[] invalidCars = {"iron man", "ironman", "blackWidow", "", "  ", " ironman"};
    String[] duplicateCars = {"iron ", " iron", "iron "};
    String[] invalidLengthCars = {"iron man", "ironman", "blackWidow", "", "  ", " ironman"};
    String[] emptyNameCars = {"iron", "", "  "};

    @Test
    @DisplayName("Racing Car 입력값이 제약조건을 준수하면 Racing Car 컬렉션을 생성한다. ")
    public void testCreateRacingCar() {
        RacingCar cars = new RacingCar(validCars);
        assertEquals(validCars.length, cars.racingCarRecords.size());
    }

    @Test
    @DisplayName("Racing Car 의 이름이 중복되면 IllegalArgumentException 예외를 던진다.")
    public void When_Car_Name_Duplicate_Throws_Exception() {
        assertThatThrownBy(() -> {
            new RacingCar(duplicateCars);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("Racing Car 이름의 길이가 5를 넘으면 예외를 던진다.")
    public void When_Car_Name_Length_Over_5_Throws_Exception() {
        assertThatThrownBy(() -> {
            new RacingCar(invalidLengthCars);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("Racing Car 이름이 비어있으면 예외를 던진다.")
    public void When_Car_Name_Empty_Throws_Exception() {
        assertThatThrownBy(() -> {
            new RacingCar(emptyNameCars);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR);
    }



}
// TODO : 3 이하, 4 이상 로직도 테스트해야한다.