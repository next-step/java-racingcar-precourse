package racinggame.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class CollectionUtils {
	private static final String DEFAULT_DELIMITER = ",";

	private CollectionUtils() {
	}

	public static <E> boolean isEmptyOrNull(Collection<E> collection) {
		return collection == null || collection.isEmpty();
	}

	public static String joining(List<String> list) {
		return joining(list, DEFAULT_DELIMITER);
	}

	public static String joining(Collection<String> strings, String delimiter) {
		if (isEmptyOrNull(strings)) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (String str : strings) {
			sb.append(str).append(delimiter);
		}

		return sb.delete(sb.lastIndexOf(delimiter), sb.length()).toString();
	}

	public static List<String> toList(String str) {
		return toList(str, DEFAULT_DELIMITER);
	}

	public static List<String> toList(String str, String delimiter) {
		String[] array = str.split(delimiter);
		List<String> list = new ArrayList<>();
		Collections.addAll(list, array);
		return list;
	}
}