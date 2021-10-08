package nextstep.utils;

public class StringBuilderUtils {

    public static StringBuilder deleteLastText(StringBuilder sb, String text) {
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf(text));
        }
        return sb;
    }

}
