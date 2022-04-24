package racingcar;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class CarTest {
    private MockedStatic<Randoms> mock;

    @Test
    void 차이름_성공() {
        Assertions.assertDoesNotThrow(() -> {
            new Car("abcde");
            new Car("193de");
        });
    }

    @Test
    void 차_생성실패_이름Null() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Car(null)
        );
    }

    @Test
    void 차_생성실패_구분자포함() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Car("ab,df")
        );
    }

    @Test
    void 차_생성실패_이름길이초과() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Car("abcedf")
        );
    }



    @Test
    void 차이름_실패_공백만() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Car("     ")
        );
    }

    @Test
    void 전진_성공() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(9);

        Car car = new Car("car1");
        car.goForward();
        Assertions.assertEquals(1, car.getDistance());

        mock.close();
    }

    @Test
    void 전진_실패() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0);

        Car car = new Car("car2");
        car.goForward();
        Assertions.assertEquals(0, car.getDistance());

        mock.close();
    }

    @Test
    void 출력_이름포함() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(9);

        Car car = new Car("car3");
        car.goForward();
        Assertions.assertTrue(car.getCurrentResult().contains(car.getName()));

        mock.close();
    }

    @Test
    void 출력_진행상황표시_전진했을때() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(9);

        Car car = new Car("car3");
        car.goForward();
        Assertions.assertTrue(car.getCurrentResult().contains("-"));

        mock.close();
    }

    @Test
    void 출력_진행상황표시_정지있을때() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(0);

        Car car = new Car("car3");
        car.goForward();
        Assertions.assertFalse(car.getCurrentResult().contains("-"));

        mock.close();
    }
}
