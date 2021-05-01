import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputTest {

    static final String testExceptionLecture = "test,array,nickname,nices";
    static final String testRightLecture = "test,nice,hobix,next";

    @Test
    @DisplayName("5개 이상의 문자열 길이가 있었을때 Exception 검출 테스트")
    public void stringFiveLectureSplitErrorTest(){
        String[] exceptionsLecture = testExceptionLecture.split(",");
        assertThatExceptionOfType(java.lang.AssertionError.class).isThrownBy(() -> {
           for(int i=0;i<exceptionsLecture.length;i++) {
               assertThat(exceptionsLecture[i].length()).isLessThanOrEqualTo(5);
           }
        });
    }

    @ParameterizedTest
    @DisplayName("해당 자료형 이상의 횟수를 입력한 경우 Exception 검출 테스트")
    @CsvSource({"2147483648"})
    public void intMoreThanInputCaseErrorTest(String parser){
        assertThatExceptionOfType(java.lang.NumberFormatException.class).isThrownBy(() -> {
            int testMoreThanValue = 0;
            assertThat(testMoreThanValue = Integer.parseInt(parser));
        }).withMessage("For input string: \"%s\"", parser);
    }

    @Test
    @DisplayName("1번 미만의 숫자로 입력한 경우 Exception 검출 테스트")
    public void intLessThanOneInputCaseErrorTest(){
        int testLessThanValue = -1;
        assertThatExceptionOfType(java.lang.AssertionError.class).isThrownBy(() -> {
            assertThat(testLessThanValue).isGreaterThanOrEqualTo(1);
        });
    }

}
