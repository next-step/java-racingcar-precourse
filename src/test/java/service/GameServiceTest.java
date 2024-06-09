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
    private static final GameService gameService = GameService.getInstance() ;

    //각 테스트가 끝나면 repository가 초기화된다.
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
    void moveCars() {

    }
    @Test
    void findWinner() {
    }


}