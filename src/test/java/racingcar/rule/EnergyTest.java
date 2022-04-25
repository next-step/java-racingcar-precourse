package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class EnergyTest {

    @DisplayName("에너지는 0~9 사이의 숫자만 가능하다")
    @Test
    void validRange() {
        //given
        int min = 0;
        int max = 9;

        //when
        Energy minEnergy = Energy.from(min);
        Energy maxEnergy = Energy.from(max);

        //then
        assertThat(minEnergy.get()).isEqualTo(min);
        assertThat(maxEnergy.get()).isEqualTo(max);
    }

    @DisplayName("에너지가 0~9 사이의 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenInvalidRange() {
        //given
        int lessThanMin = 0 - 1;
        int overMax = 9 + 1;

        //when
        Throwable lessThanMinThrown = catchThrowable(() -> Energy.from(lessThanMin));
        Throwable overMaxThrown = catchThrowable(() -> Energy.from(overMax));

        //then
        assertThat(lessThanMinThrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(overMaxThrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isLessThan() {
        //given
        int number = 5;
        Energy energy = Energy.from(number);
        Energy less = Energy.from(number - 1);

        //when
        boolean actual = less.isLessThan(energy);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    void isGraterThan() {
        //given
        int number = 5;
        Energy energy = Energy.from(number);
        Energy grater = Energy.from(number + 1);

        //when
        boolean actual = grater.isGraterThan(energy);

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("natural ordering과 equals가 일치하도록 권장된다")
    @Test
    void comparableAndEquality() {
        //given
        int sameNumber = 1;

        //when
        Energy energy = Energy.from(sameNumber);
        Energy other = Energy.from(sameNumber);

        //then
        assertThat(energy)
                .isEqualTo(other)
                .hasSameHashCodeAs(other)
                .isEqualByComparingTo(other);
    }
}