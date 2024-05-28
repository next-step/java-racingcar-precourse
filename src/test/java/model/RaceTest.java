package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(new Car("kang"), new Car("maru"), new Car("haeun"));
    }

    @Test
    public void 레이스_위치확인() {
        Race race = new Race(cars);
        race.moveCars(()-> 4);

        for (Car car : race.getCars()) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    public void 레이스_우승자결정() {
        Race race = new Race(cars);
        race.moveCars(() -> 4);
        race.getCars().get(0).move(4);

        List<Car> winners = race.getWinners();
        assertEquals(1, winners.size());
        assertEquals("kang", winners.get(0).getName());

        // 각 자동차의 위치를 검증
        assertEquals(2, race.getCars().get(0).getPosition());
        assertEquals(1, race.getCars().get(1).getPosition());
        assertEquals(1, race.getCars().get(2).getPosition());
    }

    @Test
    public void 레이스_우승자결정_여러명() {
        Race race = new Race(cars);
        race.moveCars(() -> 4);

        List<Car> winners = race.getWinners();
        assertEquals(3, winners.size());
        assertEquals("kang", winners.get(0).getName());
        assertEquals("maru", winners.get(1).getName());
        assertEquals("haeun", winners.get(2).getName());

        // 각 자동차의 위치를 검증
        assertEquals(1, race.getCars().get(0).getPosition());
        assertEquals(1, race.getCars().get(1).getPosition());
        assertEquals(1, race.getCars().get(2).getPosition());
    }
}
