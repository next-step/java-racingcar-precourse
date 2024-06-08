public class CheckRounds {
    public static void checkRounds(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("[ERROR] 이동 횟수는 0보다 커야 합니다.");
        }
    }
}
