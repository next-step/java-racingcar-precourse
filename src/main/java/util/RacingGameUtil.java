package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGameUtil {




    public static int validRoundInt(String inputValue) throws IllegalArgumentException {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException("라운드 횟수가 빈 값이다.");
        }
        if (!inputValue.matches("\\d+")) {
            throw new IllegalArgumentException("라운드 횟수는 정수여야합니다.");
        }
        int rounds = Integer.parseInt(inputValue);
        if (rounds < 1 || rounds > 12) {
            throw new IllegalArgumentException("라운드 횟수는 1~12 사이의 값이어야합니다.");
        }
        return rounds;
    }

    public static LinkedHashMap<String, Integer> judgeTheWinner(LinkedHashMap<String, Integer>  originalMap) {
        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();

        // 최대값 찾기
        int max = originalMap.values().stream().max(Integer::compare).orElse(-1);

        // 최대값을 가진 항목들을 새로운 LinkedHashMap에 추가
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        return resultMap;
    }

}

