package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.FailureMovement;
import racingcar.model.SuccessMovement;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,jason", "pobi", "pobi,jason,racer"})
    public void 자동차_이름들은_중복이_없으며_쉼표로_구분된다(String input) {
        // given
        Cars cars = new Cars(Arrays.asList(input.split(",", -1)));

        // when
        List<String> resultList = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            resultList.add(car.name());
        }
        String result = String.join(",", resultList);

        // then
        assertThat(input).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"racing,car,celina", "race,jason2,run", "car,race,moving"})
    public void 자동차_이름이_하나이상_5글자_이상인_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(Arrays.asList(input.split(",",-1))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jason,", ",jason", "jason,,pobi"})
    public void 자동차_이름이_하나이상_공백인_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(Arrays.asList(input.split(",",-1))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi,jason", "jason,pobi,jason", "jason,pobi,pobi"})
    public void 자동차_이름이_중복되는_경우_실패를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(Arrays.asList(input.split(",",-1))));
    }

    @Test
    public void 자동차_객체의_이동결과_자동차의_위치가_변경된다() {
        // given
        Cars cars = new Cars(Arrays.asList("pobi"));
        String beforePosition = cars.getCarList().get(0).position();

        // when
        cars.moveResult(new SuccessMovement());
        String afterPosition = cars.getCarList().get(0).position();

        // then
        assertThat(beforePosition).isNotEqualTo(afterPosition);
    }

    @Test
    public void 자동차_객체의_이동결과_자동차의_위치가_변경되지_않는다() {
        // given
        Cars cars = new Cars(Arrays.asList("pobi"));
        String beforePosition = cars.getCarList().get(0).position();

        // when
        cars.moveResult(new FailureMovement());
        String afterPosition = cars.getCarList().get(0).position();

        // then
        assertThat(beforePosition).isEqualTo(afterPosition);
    }
}