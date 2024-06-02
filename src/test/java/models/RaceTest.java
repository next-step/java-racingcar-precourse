package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private Race race;

    @BeforeEach
    public void setRace() {
        String[] carNames = {"pobi", "woni", "jun"};
        race = new Race(carNames);
    }
    
    @Test
    @DisplayName("우승자를 잘 가져오는지 테스트 - 우승자가 한 명인 경우")
    public void testGetOneWinner() {
        race.getCars().get(0).move(5);
        assertEquals(Arrays.asList("pobi"), race.getWinners());
    }

    @Test
    @DisplayName("우승자를 잘 가져오는지 테스트 - 우승자가 두 명인 경우")
    public void testGetTwoWinner() {
        race.getCars().get(0).move(5);
        race.getCars().get(2).move(5);
        assertEquals(Arrays.asList("pobi", "jun"), race.getWinners());
    }
}
