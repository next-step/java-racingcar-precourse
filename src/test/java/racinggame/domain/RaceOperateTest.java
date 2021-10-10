package racinggame.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceOperateTest {

    @Test
    public void 정지_생성() throws Exception{
        assertThat(RaceOperate.run(1, 3)).isEqualTo(RaceOperate.STOP);
    }

    @Test
    public void 전진_생성() throws Exception{
        assertThat(RaceOperate.run(4, 9)).isEqualTo(RaceOperate.MOVE);
    }

}