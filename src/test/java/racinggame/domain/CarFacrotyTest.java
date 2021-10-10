package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFacrotyTest {

    @Test
    void 자동차_등록() {
        CarFacroty carFacroty = new CarFacroty("퐁당퐁,퐁당퐁당,퐁당퐁당퐁");
        Cars cars = carFacroty.enter();
        assertThat(cars.getCarsSize()).isEqualTo(3);
    }

    @Test
    void 자동차_5자리이상_등록() {
        assertThatThrownBy(() -> new CarFacroty("퐁당퐁당,퐁당퐁당퐁,퐁당퐁당퐁당")).isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("[ERROR]");
    }
}
