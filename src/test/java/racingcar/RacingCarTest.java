package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {
    @Test
    void 차_생성_성공_테스트(){
        //given
        int moveMaxLimit = 5;
        String[] names = "pobi,woni,jun".split(",");

        //when
        RacingCar rc1 = new RacingCar(names[0], moveMaxLimit);
        RacingCar rc2 = new RacingCar(names[1], moveMaxLimit);
        RacingCar rc3 = new RacingCar(names[2], moveMaxLimit);

        //then
        assertThat(rc1).extracting("name").isEqualTo("pobi");
        assertThat(rc1).extracting("distance").isEqualTo(0);
        assertThat(rc2).extracting("name").isEqualTo("woni");
        assertThat(rc2).extracting("distance").isEqualTo(0);
        assertThat(rc3).extracting("name").isEqualTo("jun");
        assertThat(rc3).extracting("distance").isEqualTo(0);
    }

    @Test
    void 차_생성시_이름이_5자_이상은_실패_테스트(){
        //given
        String[] names = "pobi12,woniaaa,junabc,jung y".split(",");

        for (int i = 0; i < names.length; i++){
            String name = names[i];
            assertThrows(IllegalArgumentException.class, () -> new RacingCar(name, 5));
        }
    }

    @Test
    void 차량_전진_테스트(){
        //given
        int moveMaxLimit = 9;
        RacingCar rc = new RacingCar("pobi", moveMaxLimit);
        int realMoveCnt = 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= moveMaxLimit; i++){
            int randNum = Randoms.pickNumberInRange(1, 9);
            numbers.add(randNum);
            realMoveCnt += randNum > 3 ? 1 : 0; // 이동횟수 세기
        }

        //when
        for(int i = 0; i < moveMaxLimit; i++){
            rc.move(numbers.get(i));
        }

        //then
        System.out.println("numbers = " + numbers);
        System.out.println("realMoveCnt : " + realMoveCnt);
        assertThat(rc).extracting("distance").isEqualTo(realMoveCnt);
    }
}
