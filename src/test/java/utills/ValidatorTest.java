package utills;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Validator 유닛 테스트")
class ValidatorTest {

    @Test()
    @DisplayName("유효하지 않은 이름 값을 입력")
    void invalidNameTest() {

        //알파벳이 아닌 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abc","123","bng"};
            Validator.validCheckCarNames(names);
        });

        //중복된 값이 있는 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abc","abc","bng"};
            Validator.validCheckCarNames(names);
        });

        //5글자 이상인 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abcdefs","d","bng"};
            Validator.validCheckCarNames(names);
        });

        //이름이 5개 이상인 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abc","b","bng","pin","tom","more"};
            Validator.validCheckCarNames(names);
        });

        //이름이 한개인경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abc"};
            Validator.validCheckCarNames(names);
        });

        //횟수에 문자가 포함된 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->{
            String[] names = {"abc"};
            Validator.validCheckCarNames(names);
        });
    }

    @Test()
    @DisplayName("유효한 이름 값을 입력")
    void validNameTest() {
        String[] names = {"abc","a","abcd"};
        assertDoesNotThrow(() -> Validator.validCheckCarNames(names));
    }

    @Test
    @DisplayName("유효하지 않은 횟수 입력")
    void invalidCountTest() {
        //횟수에 숫자 외의 다른 문자 포함된 경우
        assertThrowsExactly(IllegalArgumentException.class, () ->
            Validator.validCheckCount("1td")
        );

        //유효하지 않은 범위
        assertThrowsExactly(IllegalArgumentException.class, () ->
            Validator.validCheckCount("1004")
        );
    }
}