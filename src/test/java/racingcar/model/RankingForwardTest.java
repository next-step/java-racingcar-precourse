package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.entity.Cars;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingForwardTest {
    @Test
    void 우승자_검증_테스트() {
        Cars cars = new Cars("aaa,bbb,ccc,ddd,eee");
        int count = 1;
        for (String key : cars.getCarMap().keySet()) {
            cars.getCarMap().put(key, count++);
        }

        OutputStream oStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(oStream));

        RankingForward.setCarsRanking(cars);

        assertThat("최종 우승자 : eee").isEqualTo(oStream.toString());
    }

    @Test
    void 공동우승자_검증_테스트() {
        Cars cars = new Cars("aaa,bbb,ccc,ddd,eee");
        int count = 1;
        for (String key : cars.getCarMap().keySet()) {
            cars.getCarMap().put(key, count);
        }

        OutputStream oStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(oStream));

        RankingForward.setCarsRanking(cars);

        assertThat("최종 우승자 : aaa, bbb, ccc, ddd, eee").isEqualTo(oStream.toString());
    }
}
