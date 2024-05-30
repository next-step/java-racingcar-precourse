package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
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

    @Test
    public void testGetWinners()
        throws NoSuchFieldException, IllegalAccessException {
        String carNames = "전남대1,전남대2,전남대3";
        racingGameService.initCar(carNames);
        List<Car> cars = racingGameService.getCars();

        // 직접 position 을 수정하려면 리플렉션이라는 것을 사용하여 접근해야 한다고 합니다.
        // 아직 잘 모르지만... 우선 사용해보겠습니다.
        setPosition(cars.get(0), 2);
        setPosition(cars.get(1), 3);
        setPosition(cars.get(2), 3);

        List<Car> winners = racingGameService.getWinners();
        // winners 리스트 안에 2개가 들어있는지(전남대2, 전남대3이 들어있어야 함)
        assertEquals(2, winners.size());
        // 전남대2와 전남대3이 들어있는지
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("전남대2")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("전남대3")));
    }

    // position 을 직접 조작하기 위한 메서드
    private void setPosition(Car car, int position) throws NoSuchFieldException, IllegalAccessException{
        // Car 클래스에서 이름이 position 인 필드를 가져옴
        // getDeclaredField 는 private 필드도 가져올 수 있음
        Field positionField = car.getClass().getDeclaredField("position");
        // private 인 position 필드를 접근 가능하게 허용
        positionField.setAccessible(true);
        // position 필드의 값을 설정
        positionField.set(car, position);
    }
}
