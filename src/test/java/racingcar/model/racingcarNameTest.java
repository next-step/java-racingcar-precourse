package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class racingcarNameTest {
    @Test
    void 레이싱카_이름_1개_입출력_테스트(){
        racingcarName name = new racingcarName("pobi");
        assertThat(name.getCarName()).isEqualTo("pobi");
    }
    @Test
    void 레이싱카_이름_1개_입출력_길이_제한_5이상(){
         IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                 new racingcarName("pobiyy"));
        assertEquals("[ERROR] 자동차 이름의 길이가 5를 넘었습니다.",e.getMessage());

    }
    @Test
    void 레이싱카_이름_1개_입출력_길이_제한_0(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                new racingcarName(""));
        assertEquals("[ERROR] 자동차 이름을 입력하지 않았습니다.",e.getMessage());

    }
}
