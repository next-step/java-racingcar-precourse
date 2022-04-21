package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceRecordBoard;
import racingcar.domain.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.RacingCarDto;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {
    private final int DEFAULT_LIMIT_OF_MOVE = 5;
    private final String DEFAULT_NAMES = "pobi,woni,jun";
    private final RaceRecordBoard board = new RaceRecordBoard();
    private List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void initDefaultTestData(){
        String[] arrName = DEFAULT_NAMES.split(",");
        for (int i=0; i < arrName.length; i++){
            racingCarList.add(new RacingCar(arrName[i], DEFAULT_LIMIT_OF_MOVE, board));
        }
    }

    @AfterEach
    void resetDefaultTestData(){
        board.resetRecord();
        racingCarList.clear();
    }

    @Test
    void 차_생성_후_이름_거리_테스트() {
        //given
        RacingCar rc1 = racingCarList.get(0);
        RacingCar rc2 = racingCarList.get(1);
        RacingCar rc3 = racingCarList.get(2);

        //then
        assertThat(rc1).extracting("name").isEqualTo("pobi");
        assertThat(rc1).extracting("distance").isEqualTo(0);
        assertThat(rc2).extracting("name").isEqualTo("woni");
        assertThat(rc2).extracting("distance").isEqualTo(0);
        assertThat(rc3).extracting("name").isEqualTo("jun");
        assertThat(rc3).extracting("distance").isEqualTo(0);
    }

    @Test
    void 차_생성시_이름이_5자_이상은_실패_테스트() {
        //given
        String[] names = "pobi12,woniaaa,junabc,jung y".split(",");

        //when, then
        for (int i = 0; i < names.length; i++) {
            String n = names[i];
            assertThrows(IllegalArgumentException.class, () -> new RacingCar(n, DEFAULT_LIMIT_OF_MOVE, board));
        }
    }

    @Test
    void 차량_전진_테스트() {
        //given
        int realMoveCnt = 0;
        RacingCar rc = new RacingCar("pobi", DEFAULT_LIMIT_OF_MOVE, board);

        //when
        for (int i = 1; i <= DEFAULT_LIMIT_OF_MOVE; i++) {
            int randNum = getRandomNumber();
            rc.move(randNum);

            // 수동으로 이동횟수 세기
            realMoveCnt += randNum > 3 ? 1 : 0;
        }

        //then
        System.out.println("실제 이동 거리 : " + realMoveCnt);
        assertThat(rc).extracting("distance").isEqualTo(realMoveCnt);
    }

    @Test
    void 이동_거리_현황판의_값과_차량의_최종_이동거리가_같은지_테스트() {
        // given
        RacingCar rc1 = racingCarList.get(0);
        RacingCar rc2 = racingCarList.get(1);
        RacingCar rc3 = racingCarList.get(2);

        // when
        // move 메소드 내부에서 이동 후 거리 현황판에 거리를 업데이트
        for (int i = 0; i < DEFAULT_LIMIT_OF_MOVE; i++) {
            rc1.move(getRandomNumber());
            rc2.move(getRandomNumber());
            rc3.move(getRandomNumber());
        }

        // then
        // 이동 기록 현황판의 값과 실제 차량의 최종 이동 거리가 같은지 비교
        isEqualRecord(rc1, board);
        isEqualRecord(rc2, board);
        isEqualRecord(rc3, board);
    }

    @Test
    void 최종_단독_우승자_찾기_테스트(){
        // given
        board.resetRecord();
        board.updateRecord("pobi", 4);
        board.updateRecord("woni", 2);
        board.updateRecord("june", 6);

        // when
        List<RacingCarDto> winnerList = board.findWinners();
        RacingCarDto winner = winnerList.get(0);

        // given
        assertThat(winnerList).hasSize(1);
        assertThat(winner).extracting("name").isEqualTo("june");
    }

    @Test
    void 최종_공동_우승자_찾기_테스트(){
        // given
        board.resetRecord();
        board.updateRecord("pobi", 1);
        board.updateRecord("woni", 2);
        board.updateRecord("june", 9);
        board.updateRecord("parker", 9);
        board.updateRecord("peter", 9);

        // when
        List<RacingCarDto> winnerList = board.findWinners();

        // then
        assertThat(winnerList).hasSize(3);
        assertThat(winnerList).extracting("name").containsOnly("june", "parker", "peter");
    }


    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void isEqualRecord(RacingCar rc, RaceRecordBoard board) {
        Optional<Integer> record = board.findRecord(rc.getName());
        record.ifPresent(integer -> assertThat(integer).isEqualTo(rc.getDistance()));
    }
}
