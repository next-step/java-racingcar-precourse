package racingCar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.controller.RacingCarUtil;

class RacingCarModelTest {

    private RacingCarModel racingCarModel;
    private RacingCarUtil racingCarUtil;

    @BeforeEach
    void setUp() {
        racingCarModel = new RacingCarModel();
        racingCarUtil = new RacingCarUtil();
    }

    @Test
    @DisplayName("RacingCarModel이 Initialize가 잘 되는지 테스트")
    void initCarStats() {
        String[] input = {"car1", "   car2", "c3"};
        String[] trimmedInput = racingCarUtil.trimInput(input);
        assertThat(trimmedInput).isEqualTo(new String[]{"car1", "car2", "c3"});

        Map<String, Integer> mapForTest = new HashMap<>();
        mapForTest.put("car1", 0);
        mapForTest.put("car2", 0);
        mapForTest.put("c3", 0);
        racingCarModel.initCarStats(trimmedInput);
        assertThat(racingCarModel.getCarStatus()).isEqualTo(mapForTest);
    }

    @Test
    @DisplayName("Attempts가 model에 올바르게 저장되는지 테스트")
    void getAndSetAttempts(){
        for (int i = 1; i < 1000; i++) {
            racingCarModel.setAttempts(i);
            assertThat(i).isEqualTo(racingCarModel.getAttempts());
        }

    }

    @Test
    @DisplayName("racingCar가 1칸 전진할 때 carStats에 잘 반영이 됐는지 테스트")
    void getCarStatus() {

        racingCarModel.initCarStats(new String[]{"car1", "car2", "c3", "4", "car5", "car6", "car7", "car8", "car9"});
        racingCarModel.setAttempts(1000);

        Map<String, Integer> mapForTest = racingCarModel.getCarStatus();


        for (int i = 0; i < racingCarModel.getAttempts(); i++) {
            Iterator<String> keys = mapForTest.keySet().iterator();

            int mapSize = mapForTest.size();
            int counter = 0;
            while(keys.hasNext()) {
                String key = keys.next();

                double randDouble = this.isGoForTest();
                assertTrue(randDouble > 0 && randDouble < 10);

                int tempForCompare = mapForTest.get(key);

                if (randDouble >= 4) {
                    mapForTest.put(key, mapForTest.get(key) + 1);
                    assertThat(racingCarModel.getCarStatus().get(key)).isEqualTo(tempForCompare + 1);
                }
                counter ++;
            }
            assertEquals(counter, mapSize);
        }





    }

    private double isGoForTest(){// 앞으로 갈지 결정하는 메서드, RacingCarUtil의 isGo 메서드 Simulating 하기
        return Math.random() * 10;
    }
}