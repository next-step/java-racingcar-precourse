package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacersTest {

    @Test
    void 레이서_이름_쉼표_없을때() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String readLine = "sdfsdf.sdfsdf.sdfdf";
            ArrayList<Racer> racers = new ArrayList<>();
            for (String s : readLine.split(",")) {
                racers.add(new Racer(s, 0));
            }
            new Racers(racers);
        });
    }

    @Test
    void 레이서_이름_분리_정상() {
        String readLine = "pobi,wind,flow";
        ArrayList<Racer> racer = new ArrayList<>();
        for (String s : readLine.split(",")) {
            racer.add(new Racer(s, 0));
        }

        Racers racers = new Racers(racer);
        assertThat(3).isEqualTo(racers.getRacers().size());
    }

    @Test
    void 리스트_값_확인() {
        String readLine = "pobi,wind,flow";
        ArrayList<Racer> racer = new ArrayList<>();
        for (String s : readLine.split(",")) {
            racer.add(new Racer(s, 0));
        }

        Racers racers = new Racers(racer);
        assertThat(racers.getRacers().get(0).getName()).isEqualTo("pobi");
    }

    @Test
    void 리스트_중복_테스트() {

        assertThatIllegalStateException().isThrownBy(() -> {
            String readLine = "pobi,pobi,pobi";
            ArrayList<Racer> racer = new ArrayList<>();
            for (String s : readLine.split(",")) {
                racer.add(new Racer(s, 0));
            }

            Racers racers = new Racers(racer);
        });
    }
}