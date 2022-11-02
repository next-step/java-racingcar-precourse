package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("pobi,crong,honux");
    }

    @Test
    @DisplayName("자동차_이름_,를_기준으로_구분")
    void car_name_split_separator() {
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차_이름_중복_불가능")
    void car_name_cannot_be_duplicated() {
        assertThatThrownBy(() -> new Cars("crong,crong,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차_이름_공백_불가능")
    void car_name_cannot_be_blank() {
        assertThatThrownBy(() -> new Cars(",crong,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.(공백 불가)");
    }

    @Test
    @DisplayName("자동차_이름_,,_불가능")
    void car_name_duplicate_separator_error() {
        assertThatThrownBy(() -> new Cars("crong,,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자(,)는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차_둘_이상_참여")
    void car_2_or_more_participate() {
        assertThatThrownBy(() -> new Cars("crong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 참가 인원은 2명입니다.");
        assertThat(new Cars("pobi,crong").getCars()).hasSize(2);
    }

    @Test
    @DisplayName("자동차_게임_라운드_플레이_결과_반환")
    void play_cars() {
        PlayResult result = cars.playRound(new RandomMovingStrategy());
        assertThat(result.getRoundResult()).contains("pobi : ", "crong : ", "honux : ");
    }
}
