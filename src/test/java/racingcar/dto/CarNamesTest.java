package racingcar.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @Test
    void CarNames_객체_생성() {
        CarNames carNames = new CarNames(new String[]{"pobi", "jun"});
        assertThat(carNames.getValues()).isEqualTo(Arrays.asList("pobi", "jun"));
    }

    @ParameterizedTest
    @EmptySource
    void 자동차_이름_리스트가_비어져_있을경우_에러(String[] input) {
        assertThatThrownBy(() -> new CarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주할 자동차가 하나도 없습니다.");
    }

    @Test
    void 자동차_이름이_비어져_있을경우_에러() {
        assertThatThrownBy(() -> new CarNames(new String[]{"pobi", "", "jun"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 비어져있습니다.");
    }

    @Test
    void 자동차_이름이_5글자_넘어갈경우_에러() {
        assertThatThrownBy(() -> new CarNames(new String[]{"pobi", "junooo"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자리를 넘어갈 수 없습니다.");
    }

    @Test
    void 자동차_이름_리스트에_중복된_이름이_있는경우_에러() {
        assertThatThrownBy(() -> new CarNames(new String[]{"pobi", "pobi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

}
