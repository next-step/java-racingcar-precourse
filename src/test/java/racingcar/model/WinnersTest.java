package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    @Test
    void 우승자_리스트_검증() {

        String readLine = "pobi,wind,flow";
        ArrayList<Racer> racer = new ArrayList<>();
        for (String s : readLine.split(",")) {
            racer.add(new Racer(s, 0));
        }
        Winners winners = new Winners(racer);
        List<String> arrayListStringWinners = winners.getArrayListStringWinners();

        assertThat(winners.getWinners().size()).isEqualTo(arrayListStringWinners.size());
    }
}