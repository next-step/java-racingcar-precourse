package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarName.convertRacingCarNames;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.ErrorCode;

public class RacingCarNameTest {

    @ParameterizedTest
    @CsvSource(value = {"dup,dup", "bibi,bibi,cari"}, delimiter = ':')
    void 자동차_이름이_중복되면_오류_발생(String carNames) {
        assertThatThrownBy(() -> {
            convertRacingCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름_중복.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {",", ",,,"}, delimiter = ':')
    void 쉼표로_구분된_자동차_이름을_split한_array가_비어있으면_오류_발생(String carNames) {
        assertThatThrownBy(() -> {
            convertRacingCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.유효한_자동차_이름_없음.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"bob,,bana", ",aaa", ",aaa,,bd,,,"}, delimiter = ':')
    void 쉼표로_구분된_자동차_이름을_split할_때_비어있는_자동차_이름이_있으면_오류_발생(String carNames) {
        assertThatThrownBy(() -> {
            convertRacingCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_비어있을_수_없음.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"bob,apple,banana"}, delimiter = ':')
    void 쉼표로_구분된_자동차_이름을_split할_때_6자_이상인_자동차_이름이_있으면_오류_발생(String carNames) {
        assertThatThrownBy(() -> {
            convertRacingCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_5자_이하.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"bob,apple,ban:3", "abc,aaa:2", "earth:1"}, delimiter = ':')
    void 자동차이름은_쉼표로_구분됨(String carNames, int expectSize) {
        List<RacingCarName> racingCarNames = convertRacingCarNames(carNames);
        assertThat(racingCarNames.size()).isEqualTo(expectSize);
    }

    @Test
    void 자동차_이름이_6자_이상일_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("abcdbef");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_5자_이하.getErrorMessage());
    }

    @Test
    void 자동차_이름이_비어있을_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_비어있을_수_없음.getErrorMessage());
    }
}
