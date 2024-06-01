package camp.nextstep.edu;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.presenter.api.RacingCarApi;
import camp.nextstep.edu.presenter.dto.request.Request;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarApiTests {

    private RacingCarApi racingCarApi = new RacingCarApi(null);

    @Test
    void registerRacingCars() {
        // given
        String input = "pobi,crong,honux";

        // when
        List< Car> cars = racingCarApi.parseRacingCars(Request.of(input));

        // then
        assertThat(cars).hasSize(3);
    }

    @Test
    void registerRacingCars_자동차_이름_5자_이상() {
        // given
        String input = "pobi,croong,honux,sean";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> racingCarApi.parseRacingCars(Request.of(input)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void registerRacingCars_자동차_2대_미만() {
        // given
        String input = "pobi";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> racingCarApi.parseRacingCars(Request.of(input)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차는 2대 이상이어야 합니다.");
    }

    @Test
    void startRacing() {
        // given
        String input = "5";

        // when
        int racingCount = racingCarApi.parseRacingCount(Request.of(input));

        // then
        assertThat(racingCount).isEqualTo(5);
    }

    @Test
    void startRacing_레이싱_횟수_1미만() {
        // given
        String input = "0";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> racingCarApi.parseRacingCount(Request.of(input)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 레이싱 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void startRacing_레이싱_횟수_문자열() {
        // given
        String input = "a";

        // when & then
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> racingCarApi.parseRacingCount(Request.of(input)));
        assertThat(exception.getMessage()).isEqualTo("For input string: \"a\"");
    }
}
