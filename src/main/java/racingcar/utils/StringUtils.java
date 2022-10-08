package racingcar.utils;

public class StringUtils {

    public static int getCharacterCount(String src, char find) {
        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            count += checkIsCharacter(src.charAt(i), find);
        }
        return count;
    }

    private static int checkIsCharacter(char src, char find) {
        return src == find ? 1 : 0;
    }
}
