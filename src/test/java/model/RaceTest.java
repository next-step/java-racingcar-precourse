package model;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private static final List<String> CAR_NAMES = Arrays.asList("pobi", "crong", "honux");
    private static Race race;

    @BeforeAll
    static void setUp(){
        race = new Race(CAR_NAMES);
    }

    @DisplayName("플레이 실행 - 입력한 자동차 이름들이 포함되어야한다.")
    @RepeatedTest(5)
    void TEST_play(){
        String result = race.play();
        assertThat(result).contains(CAR_NAMES);
        System.out.println(result);
    }

    @DisplayName("우승자 선정 - 우승자가 하나 이상 있어야한다.")
    @Test
    @AfterEach
    void TEST_getWinner(){
        String result = race.getWinner();
        assertThat(result).isNotEmpty();
        System.out.println("선두 : "+ result);
    }
}
