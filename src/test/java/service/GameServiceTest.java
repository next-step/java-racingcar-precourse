package service;

import domain.Car;
import domain.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    CarRepository carRepository = CarRepository.getInstance();
    private final GameService gameService = new GameService();

    @AfterEach
    void afterEach(){
        carRepository.clear();
    }
    @Test
    void createCars() {
        //given
        String[] names = {"abc","bob","tom"};
        //when
        gameService.createCars(names);
        //then
        ArrayList<Car> cars = carRepository.findAll();
        Assertions.assertEquals(cars.size(),3);
        assertEquals(cars.get(0).getName(),"abc");
        assertEquals(cars.get(0).getPosition(),0);
    }

    @Test
    void findWinner() {
    }
}