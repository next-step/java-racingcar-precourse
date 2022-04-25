package racingcar.model.record;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.name.CarName;
import racingcar.model.car.distance.ForwardDistance;
import racingcar.model.car.distance.Rpm;

public class RecordTest {

    @Test
    @DisplayName("자동차 이름이 lee, 한 번도 전진 안했을 시 => lee : ")
    void 자동차이름이_lee이고_한번도_전진하지않은경우_정상출력_테스트() {
        String expected = "lee : ";
        CarName carName = nameOf("lee");
        ForwardDistance distance = new ForwardDistance(0);

        Record report = new Record(carName, distance);
        Assertions.assertThat(report.report()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름이 lee, 한 번 전진 시 => lee : -")
    void 자동차이름이_lee이고_한번_전진한경우_정상출력_테스트() {
        String expected = "lee : -";
        CarName carName = nameOf("lee");
        ForwardDistance distance = new ForwardDistance(1);

        Record report = new Record(carName, distance);
        Assertions.assertThat(report.report()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름이 kim, 여섯 번 전진 시 => kim : ------")
    void 자동차이름이_kim이고_여섯번_전진한경우_정상출력_테스트() {
        String expected = "kim : ------";
        CarName carName = nameOf("kim");
        ForwardDistance distance = new ForwardDistance(6);

        Record report = new Record(carName, distance);
        Assertions.assertThat(report.report()).isEqualTo(expected);
    }


    private CarName nameOf(String name) {
        return new CarName(name);
    }
}
