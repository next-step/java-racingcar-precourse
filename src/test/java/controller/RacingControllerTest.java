package controller;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private RacingController racingController;

    @BeforeEach
    public void setUp(){
        racingController = new RacingController();
    }

    @Test
    @DisplayName("Carlist에 자동차의 이름들이 잘 추가되는지 확인")
    public void testAddCarList(){
        String[] carNames = {"car1","car2"};
        racingController.addCarlist(carNames);
        List<Car> carlist = racingController.getCarlist();
        assertEquals(2,carlist.size());
        assertEquals("car1",carlist.get(0).getCarname());
        assertEquals("car2",carlist.get(1).getCarname());
    }

    @Test
    @DisplayName("랜덤값을 파라미터로 전달했는데 자동차가 잘 움직이는지 확인")
    public void testMoveCarByRandNum(){
        String[] carNames = {"car1","car2"};
        racingController.addCarlist(carNames);
        List<Car> carlist = racingController.getCarlist();
        racingController.moveCarByRandNum(carlist);
        //랜덤값이 주어졌을때 한칸 움직이거나 or 움직이지않거나
        assertTrue(carlist.get(0).getMove()>=0 && carlist.get(0).getMove()<=1);
        assertTrue(carlist.get(1).getMove()>=0 && carlist.get(1).getMove()<=1);

    }

    @Test
    @DisplayName("단일 우승자 확인")
    public void testGetOneWinner(){
        String[] carNames = {"car1","car2"};
        racingController.addCarlist(carNames);
        List<Car> carlist = racingController.getCarlist();
        carlist.get(0).setMove(6);
        carlist.get(1).setMove(3);
        List<Car> winners = racingController.getWinner();
        assertEquals(1,winners.size());
        assertEquals("car1",winners.get(0).getCarname());

    }

    @Test
    @DisplayName("복수 우승자 확인")
    public void testGetManyWinner(){
        String[] carNames = {"car1","car2"};
        racingController.addCarlist(carNames);
        List<Car> carlist = racingController.getCarlist();
        carlist.get(0).setMove(6);
        carlist.get(1).setMove(6);
        List<Car> winners = racingController.getWinner();
        assertEquals(2,winners.size());
        assertEquals("car1",winners.get(0).getCarname());
        assertEquals("car2",winners.get(1).getCarname());

    }

}