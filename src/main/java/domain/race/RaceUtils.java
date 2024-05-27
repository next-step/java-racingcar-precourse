package domain.race;

public abstract class RaceUtils {

    private RaceUtils() {
    }

    public static String convertPosition(int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result = result + "-";
        }
        return result;
    }
}
