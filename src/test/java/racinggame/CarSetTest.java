package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.CarSet;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSetTest  extends NSTest {
    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Test
    void 자동차_추가() {
        CarSet carSet = CarSet.getCarSetInstance();
        carSet.addCar("latte");
        carSet.addCar("teddy");
        assertThat(carSet.getCars().size()).isEqualTo(2);
        assertThat(carSet.getCars().get(0).getName()).isEqualTo("latte");
    }

    @Test
    void 자동차_중복() {
        CarSet carSet = CarSet.getCarSetInstance();
        carSet.addCar("latte");

        assertThat(carSet.addCar("latte")).isEqualTo(false);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
