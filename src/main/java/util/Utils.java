package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 구현에 필요한 도구들을 모은 클래스
 *
 * @author Wooseok Jang
 */
public class Utils {
    private static final Random random = new Random();

    /**
     * 0 ~ 9 사이의 랜덤 정수를 반환하는 메서드
     *
     * @return 0 ~ 9 사이의 랜덤 정수
     */
    public static int generateRandomNumber() {
        return random.nextInt(10);
    }

    /**
     * 유저가 입력한 문자열을 쉼표(,)를 기준으로 분리하는 메서드
     *
     * @param input 유저가 경주할 자동차 이름을 입력한 문자열
     * @return 쉼표(,)를 기준으로 문자열을 분리하여 각각 저장한 문자열 리스트
     */
    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
