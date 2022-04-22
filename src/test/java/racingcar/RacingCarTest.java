package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;
import racingcar.domain.model.Distance;
import racingcar.domain.model.RaceRecordBoard;
import racingcar.domain.model.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {
    private final int DEFAULT_TRY_LIMIT = 5;
    private final String DEFAULT_NAMES = "pobi,woni,jun";
    private final RaceRecordBoard board = new RaceRecordBoard();
    private final List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void initDefaultTestData() {
        String[] arrName = DEFAULT_NAMES.split(",");
        for (int i = 0; i < arrName.length; i++) {
            racingCarList.add(new RacingCar(arrName[i], new Distance(DEFAULT_TRY_LIMIT), board));
        }
    }

    @AfterEach
    void resetDefaultTestData() {
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
    void 차_객체_생성시_이름이_5자_이상은_실패_테스트() {
        //given
        String[] names = "pobi12,woniaaa,junabc,jung y".split(",");

        //when, then
        for (int i = 0; i < names.length; i++) {
            String n = names[i];
            assertThrows(IllegalArgumentException.class, () -> new RacingCar(n, new Distance(DEFAULT_TRY_LIMIT), board));
        }
    }

    @Test
    void 차량_전진_테스트() {
        //given
        int distance = 0;
        RacingCar rc = new RacingCar("pobi", new Distance(DEFAULT_TRY_LIMIT), board);

        //when
        for (int i = 1; i <= DEFAULT_TRY_LIMIT; i++) {
            int randNum = getRandomNumber();
            rc.move(randNum);
            distance += randNum > 3 ? 1 : 0;
        }

        //then
        assertThat(rc).extracting("distance").isEqualTo(distance);
    }

    @Test
    void 이동_거리_현황판의_값과_차량의_최종_이동거리가_같은지_테스트() {
        // given
        RacingCar rc1 = racingCarList.get(0);
        RacingCar rc2 = racingCarList.get(1);
        RacingCar rc3 = racingCarList.get(2);

        // when
        for (int i = 0; i < DEFAULT_TRY_LIMIT; i++) {
            // move 메소드 내부에서 이동 후 현황판에 이동한 거리를 업데이트
            rc1.move(getRandomNumber());
            rc2.move(getRandomNumber());
            rc3.move(getRandomNumber());
        }

        // then
        for (RacingCar rc : racingCarList) {
            // 현황판 이동 기록 얻기
            Optional<Integer> record = board.findRecord(rc.getName());
            // 차량의 최종 이동 거리와 비교
            record.ifPresent(integer -> assertThat(integer).isEqualTo(rc.getDistance()));
        }
    }

    @Test
    void 단독차량생성후_최종_단독_우승자_찾기_테스트(){

    }

    @Test
    void 다수차량생성후_최종_단독_우승자_찾기_테스트() {
        // given
        board.resetRecord();
        board.updateRecord("pobi", 4);
        board.updateRecord("woni", 2);
        board.updateRecord("june", 6);

        // when
        List<String> winnerList = board.findWinners();
        String winner = winnerList.get(0);

        // given
        assertThat(winnerList).hasSize(1);
        assertThat(winner).isEqualTo("june");
    }

    @Test
    void 다수차량생성후_최종_공동_우승자_찾기_테스트() {
        // given
        board.resetRecord();
        board.updateRecord("pobi", 1);
        board.updateRecord("woni", 2);
        board.updateRecord("june", 9);
        board.updateRecord("parker", 9);
        board.updateRecord("peter", 9);

        // when
        List<String> winnerList = board.findWinners();

        // then
        assertThat(winnerList)
                .hasSize(3)
                .containsOnly("june", "parker", "peter");
    }

    @Test
    void 차량_생성_팩토리로_차량생성_테스트() {
        // given
        String[] names = DEFAULT_NAMES.split(",");
        CarFactory factory = new CarFactory(names, DEFAULT_TRY_LIMIT, board);

        // when
        factory.createCars();
        List<RacingCar> carList = factory.getCarList();

        // then
        // 이름, board 객체, 사이즈 검증
        assertThat(carList).hasSize(3)
                .extracting("name").containsOnly("pobi", "woni", "jun");
        assertThat(carList).extracting("recordBoard").containsOnly(board, board, board); // 원소의 순서, 중복여부 상관없이 원소값과 갯수가 일치해야함

        // 최대 이동 시도 횟수 검증
        for (RacingCar r : carList) {
            Integer limit = r.getTryLimit();
            assertThat(limit).isEqualTo(DEFAULT_TRY_LIMIT);
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
