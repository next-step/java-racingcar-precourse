package service;

import domain.Car;
import domain.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    CarRepository carRepository = CarRepository.getInstance();
    private static final GameService gameService = GameService.getInstance();


    //각 테스트가 끝나면 repository가 초기화된다.
    @AfterEach
    void afterEach(){
        carRepository.clear();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
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
    @DisplayName("최종 우승 자동차 출력 테스트")
    void findWinner() throws NoSuchFieldException, IllegalAccessException {
        //given
        String[] names = {"abc","bob","tom"};
        Integer[] positions = {1,4,4};
        for(int i=0;i<3;i++){
            Car car = new Car(names[i]);
            setPosition(car,positions[i]);
            carRepository.save(car);
        }
        String[] expected = {"bob","tom"};

        assertArrayEquals(expected,gameService.findWinner().toArray());
    }

    public static void setPosition(Car car, int position) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = car.getClass().getDeclaredField("position");
        //position 필드 set 가능하게 함
        field.setAccessible(true);
        field.setInt(car,position);
    }


}