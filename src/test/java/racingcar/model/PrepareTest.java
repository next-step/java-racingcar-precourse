package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PrepareTest extends NsTest {

    public static Prepare prepare;

    @BeforeAll
    static void initAll() {
        prepare = new Prepare();
    }

    @Test
    void 자동차_이름_요청() {
        Cars expectCars = new Cars();
        expectCars.add(new Car("one"));
        expectCars.add(new Car("two"));
        expectCars.add(new Car("three"));

        assertSimpleTest(() -> {
            run("one,two,three");
            Cars cars = prepare.requestCarName();
            for (int i = 0; i < cars.size(); i++) {
                assertThat(expectCars.get(i).getName()).isEqualTo(cars.get(i).getName());
            }
        });
    }

    @Test
    void 시도_횟수_요청() {
        int expectAttempt = 3;

        assertSimpleTest(() -> {
            run("3");
            int attempt = prepare.requestAttempt();
            assertThat(attempt).isEqualTo(expectAttempt);

        });
    }

    @Override
    protected void runMain() {

    }
}