package service;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CarRepository;

class RacingServiceTest{
    RacingService rs = new RacingService();

    @AfterEach
    public void repositoryClear(){
        rs.getCarRepository().clear();
    }

    @Test
    @DisplayName("5글자 초과일때, 에러메세지 정상작동")
    public void enrollCarsErrorMsgTest(){
        // Given
        String input = "java, c,python";
        String expectedErrorMessage = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";

        // When
        IllegalArgumentException exception = catchThrowableOfType(() -> rs.enrollCars(input), IllegalArgumentException.class);

        // Then
        assertThat(exception.getMessage()).isEqualTo(expectedErrorMessage);
    }
}
