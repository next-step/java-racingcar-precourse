package racinggame.view;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NSTest {
    private OutputView outputView;

    @BeforeEach
    void before() {
        setUp();
        outputView = new OutputView();
    }

    @Test
    void 현재_위치_출력_확인() {
        Cars cars = new Cars("carA", "carB");

        outputView.printCarsPosition(cars);

        assertThat(output()).contains("carA :", "carB :");
    }

    @Test
    void 우승자_출력_확인() {
        List<Car> winners = new ArrayList();
        winners.add(new Car("carA"));
        winners.add(new Car("carB"));

        outputView.printWinners(winners);

        assertThat(output()).contains("최종 우승자는", "carA,carB");
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    protected void runMain() {

    }
}