import Racing.exception.InputException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;


public class ExceptionTest {

    //Input 유효성 테스트
    InputException ie = new InputException();

    //이름 입력 테스트
    @ParameterizedTest
    @ValueSource(strings = {"woni", "four","pobi"})
    @DisplayName("InputException 테스트 - 정상 입력")
    void 정상_입력(String name) {
        ie.isValidName(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii","lengthOver4"})
    @DisplayName("InputException 테스트 - 길이 초과")
    void 비정상_입력_길이초과(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ie.isValidName(name))
            .withMessageContaining("[ERROR] : 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ","   "})
    @DisplayName("InputException 테스트 - 공백")
    void 비정상_입력_공백(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ie.isValidName(name))
            .withMessageContaining("[ERROR] : 이름에 공백이 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("InputException 테스트 - 이름 1자 미만")
    void 비정상_입력_1자미만(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ie.isValidName(name))
            .withMessageContaining("[ERROR] : 이름을 1자 이상 입력하세요.");
    }

    @Test
    @DisplayName("InputException 테스트 - 이름 중복")
    void 비정상_입력_중복(){
        List<String> list = Arrays.asList("pobi","woni","pobi");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ie.isDuplicatedName(list))
            .withMessageContaining("[ERROR] : 이름은 중복될 수 없습니다.");
    }


    //시도횟수 입력 테스트
    @ParameterizedTest
    @ValueSource(strings = {"12","123","4","3"})
    @DisplayName("InputException 테스트(시도횟수) - 정상입력")
    void 정상_입력_숫자(String tryNumber){
        ie.isNumber(tryNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2","네번","이십오"})
    @DisplayName("InputException 테스트(시도횟수) - 정수x")
    void 비정상_입력_정수x(String tryNumber){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(()-> ie.isNumber(tryNumber))
            .withMessageContaining("[ERROR] : 실행 횟수는 정수만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","-2"})
    @DisplayName("InputException 테스트(시도횟수) - 0이하")
    void 비정상_입력_0이하(String tryNumber){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(()-> ie.isNumber(tryNumber))
            .withMessageContaining("[ERROR] : 실행 횟수는 양의 정수만 입력 가능합니다.");
    }


}
