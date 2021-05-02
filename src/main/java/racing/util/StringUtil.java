package racing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class StringUtil {
  private StringUtil() {
  }

  public static <T> List<T> toList(String str, String separator, Function<String, T> mapper) {
    List<T> result = new ArrayList<>();
    for (String attr : split(str, separator)) {
      result.add(mapper.apply(attr));
    }
    return result;
  }

  public static String[] split(String str, String separator) {
    return str.split(separator);
  }
}
