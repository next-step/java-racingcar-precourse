package racingcar.model.finalwinner.collect;

import org.junit.jupiter.api.Test;
import racingcar.model.finalwinner.FinalWinnerName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalWinnerNamesCollectorTest {
    @Test
    public void onlyOneFinalWinner() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 1);
        advanceMap.put("C1", 1);
        advanceMap.put("D1", 1);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(1);
        assertThat(finalWinnerNames.get(0).getName().equals("A1")).isTrue();
    }

    @Test
    public void twoFinalWinnersOneTwo() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 2);
        advanceMap.put("C1", 1);
        advanceMap.put("D1", 1);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(2);
    }

    @Test
    public void twoFinalWinnersOneThree() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 1);
        advanceMap.put("C1", 2);
        advanceMap.put("D1", 1);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(2);
    }

    @Test
    public void twoFinalWinnersOneFoure() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 1);
        advanceMap.put("C1", 1);
        advanceMap.put("D1", 2);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(2);
    }

    @Test
    public void threeFinalWinnersOneTwoThree() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 2);
        advanceMap.put("C1", 2);
        advanceMap.put("D1", 1);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(3);
    }

    @Test
    public void fourFinalWinners() {
        Map<String, Integer> advanceMap = new HashMap<>();
        advanceMap.put("A1", 2);
        advanceMap.put("B1", 2);
        advanceMap.put("C1", 2);
        advanceMap.put("D1", 2);
        int maxAdvance = 2;
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnerNamesCollector.collect();
        assertThat(finalWinnerNames.size()).isEqualTo(4);
    }
}
