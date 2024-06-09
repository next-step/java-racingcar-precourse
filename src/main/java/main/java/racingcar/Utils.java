package main.java.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {
    public static List<String> splitByDelimiter(String str, String delimiter) {
        return Arrays.asList(str.split(delimiter));
    }

    public static boolean isFourOrMore() {
        Random random = new Random();
        int randomNumber = random.nextInt(10); // 0에서 9 사이의 난수 생성
        return randomNumber >= 4;
    }
}
