package model;

import org.junit.jupiter.api.*;

import java.util.Arrays;

class RaceTest {
    private static Race race;

    @BeforeAll
    static void setUp(){
        race = new Race(Arrays.asList("car1","car2","car3"));
    }

    @DisplayName("플레이 실행")
    @RepeatedTest(5)
    void TEST_play(){
        race.play();
        System.out.println(race.toString());
    }

    @DisplayName("우승자 선정 테스트")
    @Test
    void TEST_getWinner(){
        System.out.println(race.getWinner());
    }
}
