package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.domain.CarsException;
import racingcar.exception.domain.DuplicateCarsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarsTest {

    @Test
    @DisplayName("2대 미만의 자동차 생성 시 예외 발생")
    void createOneCarsError() {
        assertThatThrownBy(() -> {
            new Cars("lee");
        }).isInstanceOf(CarsException.class)
                .hasMessageContaining("[ERROR] 자동차는 두 대 이상 존재");
    }

    @Test
    @DisplayName("중복된 이름 입력 시 예외 발생 ")
    void validateDuplicate() {
        assertThatThrownBy(() -> {
            new Cars("kim,lee,kim");
        }).isInstanceOf(DuplicateCarsException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("3대의 자동차 생성")
    void createCars() {
        Cars cars = new Cars("lee,kim,park");
        assertThat(cars.getSize()).isEqualTo(3);
    }


}