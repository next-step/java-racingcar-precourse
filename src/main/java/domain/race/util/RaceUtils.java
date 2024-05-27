package domain.race.util;

public abstract class RaceUtils {

    private RaceUtils() {
    }

    // 몇번 전진했는지를 - 로 변환해주는 함수
    public static String convertPosition(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result = result + "-";
        }
        return result;
    }
}
