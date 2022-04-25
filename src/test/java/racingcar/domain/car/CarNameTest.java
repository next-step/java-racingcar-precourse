package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {

    @Test
    @DisplayName("사용자입력_split후_CarName객체_생성_테스트")
    void carNameSetUpTest() {
        List<CarName> listCarName = new ArrayList<>();
        String[] names = "Jin,Kim,Park".split(",");
        for (String name : names)
        {
            CarName carName = new CarName(name);
            listCarName.add(carName);
        }
        assertThat(listCarName).extracting("name").contains("Jin");
        assertThat(listCarName).extracting("name").contains("Park");
        assertThat(listCarName).extracting("name").contains("Jin");
    }
}
