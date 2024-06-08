package racingCar.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    /**
     * 문자열의 공백을 제거하고 콤마(,) 기준으로 파싱하여 반환하는 메서드
     * @param str
     * @return string list
     */
    public static List<String> splitStringByComma(String str) {
        return Arrays.asList(
                str.replaceAll("\\s+","")      // 공백 모두 제거
                        .split(",")
        );
    }
}
