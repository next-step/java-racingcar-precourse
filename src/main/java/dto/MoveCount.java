package dto;

public record MoveCount(
        int count
) {
    public MoveCount(String count) {
        this(validateCount(count));
    }

    private static int validateCount(String count) {
        if (!count.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 이동 횟수는 숫자여야 합니다.");
        }

        int countInt = Integer.parseInt(count);

        if (countInt < 1 || countInt > 10000) {
            throw new IllegalArgumentException("[ERROR] 이동 횟수는 1 이상 10000이하 여야 합니다.");
        }

        return countInt;
    }
}
