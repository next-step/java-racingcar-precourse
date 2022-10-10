package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingcarModel;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarModelTest {

    @Test
    public void makeModelTest() {
        RacingcarModel model = new RacingcarModel();
        assertThat(model).isInstanceOf(RacingcarModel.class);
    }

    @Test
    public void addCarTest() {
        RacingcarModel model = new RacingcarModel();
        model.addCar("1");
        model.addCar("2");
        model.addCar("3");
        assertThat(model).isInstanceOf(RacingcarModel.class);
        assertThat(model.getCarLen()).isEqualTo(3);
    }

}
