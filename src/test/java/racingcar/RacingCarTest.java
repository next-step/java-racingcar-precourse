package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RaceRecordBoard;
import racingcar.domain.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {
    @Test
    void 차_생성_성공_테스트(){
        //given
        int moveMaxLimit = 5;
        String[] names = "pobi,woni,jun".split(",");

        //when
        RacingCar rc1 = new RacingCar(names[0], moveMaxLimit, new RaceRecordBoard());
        RacingCar rc2 = new RacingCar(names[1], moveMaxLimit, new RaceRecordBoard());
        RacingCar rc3 = new RacingCar(names[2], moveMaxLimit, new RaceRecordBoard());

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
            assertThrows(IllegalArgumentException.class, () -> new RacingCar(name, 5, new RaceRecordBoard()));
        }
    }

    @Test
    void 차량_전진_테스트(){
        //given
        int moveMaxLimit = 9;
        RacingCar rc = new RacingCar("pobi", moveMaxLimit, new RaceRecordBoard());
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

    @Test
    void 이동시마다_거리_기록_현황판에_업데이트_되는지_테스트(){
        // 이동 기록 현황판 객체 생성
        RaceRecordBoard board = new RaceRecordBoard();

        // 최대 시도 횟수 설정
        int MAX_MOVE_DISTANCE = 5;

        // 3개 차량을 생성 - 이름 부여
        RacingCar rc1 = new RacingCar("pobi", MAX_MOVE_DISTANCE, board);
        RacingCar rc2 = new RacingCar("woni", MAX_MOVE_DISTANCE, board);
        RacingCar rc3 = new RacingCar("jun", MAX_MOVE_DISTANCE, board);

        // 최대 시도 횟수만큼 차량을 이동
        for(int i = 0; i < MAX_MOVE_DISTANCE; i++){
            // move 메소드에서 이동시 마다 기록 현황판에 이동 기록을 업데이트
            rc1.move(getRandomNumber());
            rc2.move(getRandomNumber());
            rc3.move(getRandomNumber());
        }

        // 이동 기록 현황판의 값과 실제 차량의 이동 거리가 같은지 비교
        isEqualRecord(rc1, board);
        isEqualRecord(rc2, board);
        isEqualRecord(rc3, board);
    }

    public int getRandomNumber(){
       return Randoms.pickNumberInRange(1, 9);
    }

    public void isEqualRecord(RacingCar rc, RaceRecordBoard board){
        Optional<Integer> record = board.findRecord(rc.getName());
        record.ifPresent(integer -> assertThat(integer).isEqualTo(rc.getDistance()));
    }
}
