/*
 * Common
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.utils;

public final class Common {

    //private static final Common common = new Common();

    private Common() {

    }

    /**
     * @param value 전달받은 문자열
     * @return 문자열 비어있는지 여부
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }
}
