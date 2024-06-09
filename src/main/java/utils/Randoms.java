package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randoms {
    private static final Random random = ThreadLocalRandom.current();
    private Randoms() {
    }

    public static List<Integer> pickNumbersInRange(final int count, final int start, final int end){
        validateRange(start, end);
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < count; i++){
            randomNumbers.add(start + random.nextInt(end - start + 1));
        }

        return randomNumbers;
    }

    private static void validateRange(final int start, final int end){
        if (start > end) {
            throw new IllegalArgumentException(String.format("[Error]: 시작 번호[%d]가 끝 번호[%s] 보다 큽니다.", start, end));
        }
    }
}
