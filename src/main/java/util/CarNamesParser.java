package util;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser {

    /**
     * 유저가 입력한 문자열을 쉼표(,)를 기준으로 분리하는 메서드
     *
     * @param input 유저가 경주할 자동차 이름을 입력한 문자열
     * @return 쉼표(,)를 기준으로 문자열을 분리하여 각각 저장한 문자열 리스트
     */
    public static List<String> parse(String input) {
        return Arrays.asList(input.split(","));
    }
}
