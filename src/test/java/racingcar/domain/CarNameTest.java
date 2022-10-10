package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @ParameterizedTest(name = "자동차 이름 래퍼클래스가 정상 생성되는지 확인한다. [자동차 이름 : {0}]")
    @ValueSource(strings = {"일", "일이", "일이삼", "일이삼사", "일이삼사오"})
    void initTest(String expectedCarName) {
        // given
        int expectedMaxLengthCarName = 5;

        // when
        CarName carName = CarName.from(expectedCarName);

        //then
        assertThat(carName.getName()).as("자동차 이름이 정상적으로 대입 되었는지 확인")
                .isEqualTo(expectedCarName);
        assertThat(CarName.MAX_LENGTH_CAR_NAME).as("자동차 이름 최대 길이가 의도한 값으로 설정되어있는지 확인.")
                .isEqualTo(expectedMaxLengthCarName);
    }

    @ParameterizedTest(name = "(예외 테스트) 자동차 이름이 0 또는 null인 경우 IllegalArgumentException이 발생한다. [자동차 이름 : {0}]")
    @NullAndEmptySource
    void exceptionTest(String nullAndEmptyCarName) {
        // then
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        //when
                        () -> CarName.from(nullAndEmptyCarName)
                )
                .withMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @ParameterizedTest(name = "(예외 테스트) 자동차 이름이 5자 초과인 경우 IllegalArgumentException이 발생한다. [자동차 이름 : {0}]")
    @ValueSource(strings = {"123456", "일이삼사오육"})
    void exceptionTest1(String moreThanMaxLengthCarName) {
        //when
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        () -> CarName.from(moreThanMaxLengthCarName)
                )
                .withMessage("자동차 이름은 %d자 이하만 가능합니다.", CarName.MAX_LENGTH_CAR_NAME);
    }
}