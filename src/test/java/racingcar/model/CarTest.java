package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.model.util.NumberGenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {
    private static MockedStatic<Randoms> randoms;
    private static MockedStatic.Verification verification = () -> Randoms.pickNumberInRange(anyInt(), anyInt());
    @BeforeAll
    static void before() {
        randoms = mockStatic(Randoms.class);
    }

    @Test
    void 자동차_이름_설정_테스트() {
        // given

        // when
        Car car = new Car("pobi");
        // then
        assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_전진_횟수_증가() {
        // given
        Car car = new Car("pobi");
        // when
        car.addMoveCnt();
        // then
        assertThat(car.getMoveCnt()).isEqualTo(1);
    }

    @Test
    void 자동차_움직임_여부_테스트_정지() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return pickNumberInRange(0, 3);
            }
        };
        Car car = new Car("pobi");
        // when
        // then
        assertThat(car.isMovealble(numberGenerator.generateNumber())).isEqualTo(false);
    }

    @Test
    void 자동차_움직임_여부_테스트_전진() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return pickNumberInRange(4, 9);
            }
        };
        Car car = new Car("pobi");
        // when
        // then
        assertThat(car.isMovealble(numberGenerator.generateNumber())).isEqualTo(true);
    }

    @Test
    void 자동차_MOVE메서드_테스트_정지() {
        // given
        Car car = new Car("pobi");
        randoms.when(verification).thenReturn(1);
        // when
        car.move();
        // then
        assertThat(car.getMoveCnt()).isEqualTo(0);
    }

    @Test
    void 자동차_MOVE메서드_테스트_전진() {
        // given
        Car car = new Car("pobi");
        randoms.when(verification).thenReturn(5);
        // when
        car.move();
        // then
        assertThat(car.getMoveCnt()).isEqualTo(1);
    }

    @AfterAll
    public static void after() {
        randoms.close();
    }
}
