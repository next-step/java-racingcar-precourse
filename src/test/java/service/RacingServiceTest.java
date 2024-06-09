package service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    @DisplayName("우승자 명단 반환")
    public void getWinnerList(){
        //given
        RacingCarDTO car1 = new RacingCarDTO("car1");
        RacingCarDTO car2 = new RacingCarDTO("car2");
        RacingCarDTO car3 = new RacingCarDTO("car3");
        car1.setForward(1);
        car2.setForward(3);
        car3.setForward(3);

        ArrayList<String> expected = new ArrayList<>(List.of("car2", "car3"));

        //when
        rs.getCarRepository().getAllCars().add(car1);
        rs.getCarRepository().getAllCars().add(car2);
        rs.getCarRepository().getAllCars().add(car3);

        //then
        assertThat(expected).isEqualTo(rs.getWinnerArrList());
    }
}
