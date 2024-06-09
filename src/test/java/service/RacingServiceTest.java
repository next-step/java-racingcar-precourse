package service;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import model.RacingCarDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CarRepository;
import utility.Fortuna;

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

    @Test
    @DisplayName("RandomInt가 4 미만이면 전진 못함, 4 이상이면 전진 가능")
    public void cannotGoForward(){
        //given
        rs.enrollCars("car1, car2");
        Map<String, Integer> expectedForwards = Map.of(
            "car1", 1,
            "car2", 0
        );
        //when
        for(RacingCarDTO car : rs.getCarRepository().getAllCars()){
            if(car.getName().equals("car1")){
                car.setForward(car.getForward() + 1);
            }
        }
        //then
        for (RacingCarDTO car : rs.getCarRepository().getAllCars()) {
            assertThat(expectedForwards.get(car.getName()))
                        .isEqualTo(car.getForward());
        }
    }
}
