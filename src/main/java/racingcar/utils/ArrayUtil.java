package racingcar.utils;

import java.util.ArrayList;

public class ArrayUtil {

    public static ArrayList<String> toArrayList(String[] strings) {
        ArrayList<String> textList = new ArrayList<>();
        for (String string : strings) {
            textList.add(string);
        }
        return textList;
    }
}
