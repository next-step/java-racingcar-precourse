package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private final Race race = new Race();

    @Test
    void testRace() {
        // given
        String[] names = {"pobi", "nana", "james"};

        // when
        Race race1 = new Race(names);
        List<Car> carList = race1.getCarList();

        // then
        for (int i = 0; i < carList.size(); i++) {
            assertEquals(names[i], carList.get(i).getName());
        }
    }

    @Test
    void testRacing() {
        // given
        String[] names = {"pobi", "nana", "james"};

        // when
        Race race1 = new Race(names);
        race1.racing();
        List<Car> carList = race1.getCarList();

        // then
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
    }

    @Test
    void testMoveEachCar() {
        // given
        Car car = new Car("temp");
        int raceCount = 10;

        // when
        for (int i = 0; i < raceCount; i++) {
            race.moveEachCar(car);
        }

        String[] tet = {"rew"};

        // then
        System.out.println(car.getPosition());
    }

    @Test
    void testGenerateRandomNumber() {
        // given
        int count = 10000;

        // when // then
        for (int i = 0; i < count; i++) {
            int temp = race.generateRandomNumber();
            assertTrue(temp >= 0 && temp < 10);
        }
    }
}