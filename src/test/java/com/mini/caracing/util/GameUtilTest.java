package com.mini.caracing.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameUtilTest {

    @Test
    @DisplayName("최대 거리 반환 테스트")
    void testGetMaxDistance() {
        HashMap<String, Integer> carDistances = new LinkedHashMap<>();
        carDistances.put("Car1", 1);
        carDistances.put("Car2", 2);
        carDistances.put("Car3", 3);

        assertThat(GameUtil.getMaxDistance(carDistances)).isEqualTo(3);
    }
}