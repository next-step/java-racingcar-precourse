import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/* 해당 class들은 사용자들의 입력을 받지 않기 때문에, 초과값 경우의 수를 계산하지 않음 */
public class GameTest {

    @ParameterizedTest
    @DisplayName("값에 따른 전진 및, 멈춤 테스트")
    @ValueSource(ints = {4,7,9,3})
    public void upDownInputValueTest(int randomCount){
       int Count = 1;
       if(randomCount < 4){
           Count--;
           assertThat(Count).isEqualTo(0);
       }else{
           Count++;
           assertThat(Count).isEqualTo(2);
       }
    }

    @Test
    @DisplayName("랜덤 값 0 ~ 9까지의 값인지 확인")
    public void randomizeValueTest(){
        Random random = new Random();
        assertThat(random.nextInt(10)).isLessThanOrEqualTo(10);
    }

}
