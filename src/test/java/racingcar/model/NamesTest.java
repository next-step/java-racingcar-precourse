package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.constant.GameEnvironment;
import racingcar.exception.DuplicatedCarNameException;
import racingcar.exception.InvalidCarNameSizeException;
import racingcar.view.UserInput;

public class NamesTest {

    @Test
    @DisplayName("올바른 사용자 입력(자동차 이름)에 대해 생성되는 리스트 크기 검증")
    void validUserInputGenerateMatchSize() {

        // given
        String userInput = "pobi,crong,honux";
        int userInputSize = userInput.split(GameEnvironment.CAR_NAME_DELIMITER).length;
        UserInput validUserInput = new UserInput(userInput);

        // when
        Names names = new Names(validUserInput);

        // then
        assertThat(names.size()).isEqualTo(userInputSize);
    }

    @Test
    @DisplayName("올바른 사용자 입력(자동차 이름)에 대해 예외가 발생하지 않음")
    void validUserInputNoException() {

        // given
        UserInput validUserInput = new UserInput("pobi,crong,honux");

        // then
        assertThatNoException().isThrownBy(() -> new Names(validUserInput));
    }

    @Test
    @DisplayName("올바르지 않은 사용자 입력(자동차 이름)에 대해 예외가 발생")
    void inValidUserInputOccursException() {

        // given
        UserInput inValidUserInput = new UserInput("123456,1,12");

        // then
        assertThatThrownBy(() -> new Names(inValidUserInput))
                .isInstanceOf(InvalidCarNameSizeException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있다면 예외 발생")
    void isNotContainsDuplicatedName() {

        // given
        UserInput inValidUserInput = new UserInput("kyh,kyh");

        // then
        assertThatThrownBy(() -> new Names(inValidUserInput))
                .isInstanceOf(DuplicatedCarNameException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_CAR_NAME);
    }

    @Test
    @DisplayName("index로 Name 인스턴스 조회 및 객체 동등성 검증")
    void findByIndex() {
        // given
        Names names = new Names(new UserInput("0,1,2,3"));

        // then
        assertThat(names.get(1)).isEqualTo(new Name("1"));
        assertThat(names.get(0)).isNotEqualTo(new Name("1"));
    }
}
