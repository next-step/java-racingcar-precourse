package com.freeefly.util;

public class StringUtils {
    public static String getIterableDashes(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
