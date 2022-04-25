package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    @DisplayName("전진_테스트")
    void 전진_테스트() {
        Car car = new Car("pobi");
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.READY);

        car.go();
        Assertions.assertEquals(car.getMoveCount(), 1);
        Assertions.assertEquals(car.getStatus(), CarStatus.GO);
    }

    @Test
    @DisplayName("멈춤_테스트")
    void 멈춤_테스트() {
        Car car = new Car("pobi");
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.READY);

        car.stop();
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.STOP);
    }

    @Test
    @DisplayName("입력_받은_값으로_차_생성")
    void 입력_받은_값으로_차_생성() {
        String input = "pobi,javaj,woni";

        Cars cars = Application.makeCars(input);
        Assertions.assertEquals(cars.getSize(), 3);
    }

    @Test
    @DisplayName("사용자_이름_검증")
    void 사용자_이름_검증() {
        String input = "pobi,javajigi";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.makeCars(input));
    }

    @Test
    @DisplayName("이동거리_세팅_테스트")
    void 이동거리_세팅_테스트() {
        int maxMoveCount = 5;
        String input = "pobi,javaj,woni";
        Cars cars = Application.makeCars(input);
        cars.setMaxMoveCount(maxMoveCount);

        for (Car car : cars.getCars()) {
            Assertions.assertEquals(car.getMaxMoveCount(), 5);
        }
    }

    @Test
    @DisplayName("이름_중복_검증")
    void 이름_중복_검증() {
        String input = "pobi,javaj,pobi";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.makeCars(input));
    }

    @Test
    @DisplayName("랜덤값_생성_후_자동차_움직이기")
    void 랜덤값_생성_후_자동차_움직이기() {
        Car car = new Car("pobi");
        Assertions.assertEquals(car.getStatus(), CarStatus.READY);
        Assertions.assertEquals(car.getMoveCount(), 0);

        car.move();
        Assertions.assertNotEquals(car.getStatus(), CarStatus.READY);
    }

    @Test
    @DisplayName("도착_자동차_확인하기")
    void 도착_자동차_확인하기() {
        Car car = new Car("pobi");
        car.setMaxMoveCount(5);
        car.go();
        car.go();
        car.go();
        car.go();
        car.go();

        Assertions.assertTrue(car.checkStatusFinished());
    }

    @Test
    @DisplayName("자동차_움직인_거리_출력_테스트")
    void 자동차_움직인_거리_출력_테스트() {

        Car car = new Car("pobi");
        car.go();
        car.go();
        car.go();

        Assertions.assertEquals("pobi : ---", car.printMoveCount());
    }

    @Test
    @DisplayName("자동차_우승자_확인_테스트")
    void 자동차_우승자_확인_테스트() {
        Car car1 = new Car("pobi");
        car1.setMaxMoveCount(2);
        car1.go();
        car1.go();

        Car car2 = new Car("javag");
        car2.setMaxMoveCount(2);
        car2.go();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = new Cars(carList);
        Assertions.assertTrue(cars.checkArriveCar());
    }

    @Test
    @DisplayName("최종_우승자_출력_테스트")
    void 최종_우승자_출력_테스트() {
        Car car1 = new Car("pobi");
        car1.setMaxMoveCount(2);
        car1.go();
        car1.go();

        Car car2 = new Car("javag");
        car2.setMaxMoveCount(2);
        car2.go();
        car2.go();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = new Cars(carList);
        Assertions.assertEquals(cars.printArriveCarName(), "최종 우승자: pobi,javag");
    }
}
