package racingcar.Controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Test
    void 게임참여_Car_LIST_생성확인() {
        // given
        String input = "pobi, dobi";
        String[] str = input.split(",");
        Controller controller = new Controller();
        // when
        List<Car> carList = controller.makeCarList(str);
        // then
        assertThat(carList.get(0).getCarName()).isEqualTo("pobi");
        assertThat(carList.get(1).getCarName()).isEqualTo("dobi");
    }
}