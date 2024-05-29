package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.service.RacingGameService;
import racinggame.domain.Car;

public class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeEach
    public void setUp() {
        racingGameService = new RacingGameService();
    }

    // 사용자에게 입력받은 Car 의 이름들이 cars 리스트에 제대로 들어가는지 테스트
    @Test
    public void testInitCar(){
        String carNames = "전남대, 부산대, 경북대, 충남대, 강원대";
        racingGameService.initCar(carNames);
        List<Car> cars = racingGameService.getCars();

        assertEquals(5, cars.size());
        assertEquals("전남대", cars.get(0).getName());
        assertEquals("부산대", cars.get(1).getName());
        assertEquals("경북대", cars.get(2).getName());
        assertEquals("충남대", cars.get(3).getName());
        assertEquals("강원대", cars.get(4).getName());
    }


    @Test
    public void testRace(){
        String carNames = "전남대, 부산대, 경북대, 충남대, 강원대";
        racingGameService.initCar(carNames);
        racingGameService.race(5);

        // race 를 5번 했을 경우 position 은 0 ~ 5 사이의 값을 가지게 되는지 테스트
        List<Car> cars = racingGameService.getCars();
        for(Car car : cars){
            assertTrue(car.getPosition() >= 0 && car.getPosition() <= 5);
        }
    }
}
