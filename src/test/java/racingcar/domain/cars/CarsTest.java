package racingcar.domain.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class CarsTest {

    @Test
    @DisplayName("Cars 객체가 설정된 car의 객체들의 정보를 정상적으로 반환하는지 확인한다")
    void 자동차_리스트_정상_반환_테스트() {
        List<Car> carList = new ArrayList<>();

        NextStepCar nextStepCar1 = new NextStepCar("car1");
        NextStepCar nextStepCar2 = new NextStepCar("car2");
        NextStepCar nextStepCar3 = new NextStepCar("car3");

        nextStepCar1.move();
        nextStepCar2.move();
        nextStepCar3.move();

        carList.add(nextStepCar1);
        carList.add(nextStepCar2);
        carList.add(nextStepCar3);

        Cars cars = new Cars(carList);

        assertEquals(nextStepCar1, cars.getCar(0), "설정된 car 객체와 가져온 car객체가 다릅니다.");
        assertEquals(nextStepCar2, cars.getCar(1), "설정된 car 객체와 가져온 car객체가 다릅니다.");
        assertEquals(nextStepCar3, cars.getCar(2), "설정된 car 객체와 가져온 car객체가 다릅니다.");

    }

    @Test
    @DisplayName("Cars 객체가 게임 실행 후 max값을 정상적으로 반환하는지 확인한다.")
    void 자동차_1등_정상_반환_테스트() {

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {

                    List<Car> carList = new ArrayList<>();

                    NextStepCar nextStepCar1 = new NextStepCar("car1");
                    NextStepCar nextStepCar2 = new NextStepCar("car2");
                    NextStepCar nextStepCar3 = new NextStepCar("car3");

                    for(int i=0; i<2; i++){
                        nextStepCar1.move();
                        nextStepCar2.move();
                        nextStepCar3.move();
                    }

                    carList.add(nextStepCar1);
                    carList.add(nextStepCar2);
                    carList.add(nextStepCar3);

                    Cars cars = new Cars(carList);

                    assertEquals(2, cars.getMaxLocation(), "max 값은 2여야 합니다.");

                },
                1,new Integer[]{5,3,3,7,2}
        );
    }


    @Test
    @DisplayName("Cars 객체가 location과 name 기준으로 정상적으로 정렬하는지 확인한다.")
    void 자동차_정렬_테스트() {

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {

                    List<Car> carList = new ArrayList<>();

                    NextStepCar nextStepCar1 = new NextStepCar("car1");
                    NextStepCar nextStepCar2 = new NextStepCar("car2");
                    NextStepCar nextStepCar3 = new NextStepCar("car3");

                    for(int i=0; i<2; i++){
                        nextStepCar1.move();
                        nextStepCar2.move();
                        nextStepCar3.move();
                    }

                    carList.add(nextStepCar1);
                    carList.add(nextStepCar2);
                    carList.add(nextStepCar3);

                    Cars cars = new Cars(carList);
                    cars.getMaxLocation();

                    assertEquals("car2", cars.getCar(0).getName(), "정렬 후 첫번째 car는 'car2'여야 합니다.");
                    assertEquals("car3", cars.getCar(1).getName(), "정렬 후 두번째 car는 'car3'여야 합니다.");
                    assertEquals("car1", cars.getCar(2).getName(), "정렬 후 세번째 car는 'car1'여야 합니다.");

                },
                1,new Integer[]{5,7,3,7,8}
        );
    }
}