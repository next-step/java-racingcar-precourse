package racinggame.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.RacingCar;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.utils.RacingGameUtils.*;

public class RacingGameUtilsTest {

    @ParameterizedTest(name = "자동차 이름 [{0}] 쉼표 기준으로 구분하면 배열 사이즈는 {1} 이다")
    @CsvSource(value = {  "pobi,crong,honux:3"
                        , "pobi,crong,honux,elice:4"
                        , "pobi,crong,honux,elice,mark:5" }
                        , delimiter = ':')
    void 입력받은_자동차_이름을_쉼표_기준으로_구분한다(String racingCarNameInput, int lengthInput) {
        assertThat(racingCarNameSplit(racingCarNameInput).length).isEqualTo(lengthInput);
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 0자 이하면 IllegalArgumentException 발생한다")
    @ValueSource(strings = {","})
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_0자_이하_IllegalArgumentException_발생한다(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> {
                        isValidRacingCarNameLengthLimit(racingCarName);
                    });
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 초과면 IllegalArgumentException 발생한다")
    @ValueSource(strings = {"javaji,javamaster"})
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_5자_초과_IllegalArgumentException_발생한다(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThatExceptionOfType(NoSuchElementException.class)
                    .isThrownBy(() -> {
                        isValidRacingCarNameLengthLimit(racingCarName);
                    });
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 공백을 제거한다")
    @CsvSource(value = {  "pobi ,crong ,honux :pobi,crong,honux"
                        , " pobi, crong, honux:pobi,crong,honux"
                        , " pobi , crong , honux :pobi,crong,honux" }
                        , delimiter = ':')
    void 쉼표_기준으로_구분한_자동차_이름의_앞뒤_공백을_제거한다(String before, String after) {
        String[] beforeNames = racingCarNameSplit(before);
        String[] afterNames = racingCarNameSplit(after);

        for (int i = 0; i < beforeNames.length; i++) {
            assertThat(beforeNames[i]).isEqualTo(afterNames[i]);
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 초과면 메세지를 출력한다")
    @ValueSource(strings = {"javaji,javamaster"})
    void 자동차_이름의_길이가_5자_초과_메세지를_출력한다(String racingCarName) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                    isValidRacingCarNameLengthLimit(racingCarName);
                })
                .withMessage(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "경주의 시도할 횟수[{0}]는 0보다 큰 숫자를 입력해야 한다")
    @ValueSource(ints = {0, -10})
    void 경주의_시도할_횟수는_0_보다_큰_숫자를_입력해야_한다(int tryCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    isValidTryCountGreaterThanZero(tryCount);
                })
                .withMessage(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "[{0}] 경주의 시도할 횟수 입력값은 숫자만 유효하다")
    @ValueSource(strings = {"a", "B", "%", "한글", "10.5"})
    void 입력값은_숫자만_유효하다(String readLine) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    isValidOnlyNumber(readLine);
                })
                .withMessage(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "[{0}] 경주의 시도할 횟수 입력값은 0보다 큰 숫자만 유효하다")
    @ValueSource(strings = {"1", "5", "10", "100"})
    void 입력값은_0_보다_큰_숫자만_유효하다(String readLine) {
        assertThatCode(() -> isValidTryCount(readLine)).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "랜덤값이 [{0}] 이상이면 자동가 전진한다")
    @ValueSource(ints = {CHECK_NUMBER_VALUE})
    void 자동차가_전진한다(int pickNumber) {
        RacingCar racingCar = new RacingCar("pobi");
        if (isMoved(pickNumber)) {
            racingCar.move();
            assertThat(racingCar.getMovesCount()).isEqualTo(1);
        }
    }

    @ParameterizedTest(name = "랜덤값이 [{0}] 이하면 자동가 멈춘다")
    @ValueSource(ints = {CHECK_NUMBER_VALUE - 1})
    void 자동차가_멈춘다(int pickNumber) {
        RacingCar racingCar = new RacingCar("pobi");
        if (!isMoved(pickNumber)) {
            racingCar.stop();
            assertThat(racingCar.getMovesCount()).isEqualTo(0);
        }
    }
}
