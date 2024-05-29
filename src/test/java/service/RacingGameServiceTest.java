package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
