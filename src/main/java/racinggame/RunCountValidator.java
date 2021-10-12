package racinggame;

public class RunCountValidator {
    private static final int MIN_RUN_COUNT = 1;

    public static void validate(int runCount) {
        if (runCount < MIN_RUN_COUNT)
            throw new IllegalArgumentException("[ERROR] 실행 횟수는 1회 이상이어야 합니다");
    }
}
